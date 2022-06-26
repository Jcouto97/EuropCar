package europcar.project.services;

import europcar.project.command.RentalDto;
import europcar.project.converters.RentalConverterImp;
import europcar.project.exceptions.RentalNotFoundException;
import europcar.project.exceptions.RentingException;
import europcar.project.exceptions.UserNotFoundException;
import europcar.project.exceptions.VehicleNotFoundException;
import europcar.project.persistence.models.Rental;
import europcar.project.persistence.models.User;
import europcar.project.persistence.models.Vehicle;
import europcar.project.persistence.repositories.RentalsRepositoryI;
import europcar.project.persistence.repositories.UserRepository;
import europcar.project.persistence.repositories.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static europcar.project.exceptions.ExceptionMessages.ExceptionMessages.*;
import static java.time.temporal.ChronoUnit.DAYS;

@Service
@AllArgsConstructor
public class RentalServiceImp implements RentalServiceI {
    private RentalsRepositoryI repository;
    private RentalConverterImp converter;
    private UserRepository userRepository;
    private VehicleRepository vehicleRepository;

    @Override
    public List<RentalDto> getRentals() {
        return this.converter.entityListToDtoList(this.repository.findAll());
    }

    @Override
    public RentalDto getRentalById(Long id) {
        return this.converter.entityToDto(
                this.repository.findById(id).orElseThrow(() ->
                        new RentalNotFoundException(RENTAL_NOT_FOUND)));
    }

    @Override
    public List<RentalDto> getRentalsByUser(String user) {
        List<Rental> rents;
        try {
            Long userId = Long.parseLong(user);
            rents = this.repository.findByUserId(userId);
        } catch (Exception e) {
            rents = this.repository.findByUserName(user);
        }
        return this.converter.entityListToDtoList(rents);
    }

    @Override
    public List<RentalDto> getRentalsByVehicle(Long vehicleId) {
        return this.converter.entityListToDtoList(
                this.repository.findByVehicleId(vehicleId));
    }

    @Override
    public void deleteRental(Long id) {
        Rental rental = this.repository.findById(id)
                .orElseThrow(() -> new RentalNotFoundException(RENTAL_NOT_FOUND));

        if (rental.getReturnDate() == null || !rental.isPaid()) throw new RentingException(RENTAL_UP);
        this.repository.delete(rental);
    }

    public RentalDto rentVehicle(Long userId, Long vehicleId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
        if (user.isRenting()) throw new RentingException(USER_RENTING);

        //Verifica se o cliente já pagou os rents anteriores
        user.getRentals().forEach(rent -> {
            if (!rent.isPaid()) throw new RentingException(NOT_PAID);
        });

        Vehicle vehicle = this.vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new VehicleNotFoundException(VEHICLE_NOT_FOUND));
        if (vehicle.isRented()) throw new RentingException(String.format(VEHICLE_RENTED));

        user.setRenting(true);
        vehicle.setRented(true);

        Rental rental = getRental(user, vehicle);
        user.addRental(rental);
        vehicle.addRental(rental);

        Rental savedRental = this.repository.save(rental);
        RentalDto rentalDto = this.converter.entityToDto(savedRental);
        rentalDto.setVehicleId(vehicle.getId());
        rentalDto.setUserId(user.getId());
        return rentalDto;
    }

    private Rental getRental(User user, Vehicle vehicle) {
        return Rental.builder()
                .user(user)
                .vehicle(vehicle)
                .rentDate(LocalDate.now())
                .build();
    }

    public RentalDto returnVehicle(Long userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
        Rental rental = user.getRentals().stream()
                .filter(rent -> rent.getReturnDate() == null)
                .findFirst().orElseThrow(() -> new RentalNotFoundException(RENTAL_NOT_FOUND));

        rental.setReturnDate(LocalDate.now());
        rental.setPrice((int)
                (DAYS.between(rental.getReturnDate(), rental.getRentDate()) + 1) *
                rental.getVehicle().getPricePerDay());

        user.setRenting(false);
        rental.getVehicle().setRented(false);

        return this.converter.entityToDto(this.repository.save(rental)); //update ao que ja esta para ter data nova
    }

    public int payRent(Long id, int payment) {
        User user = this.userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));

        Rental rentalToPay = user.getRentals().stream()
                .filter(rent -> !rent.isPaid() && rent.getReturnDate() != null)
                .findFirst()
                .orElseThrow(() -> new RentalNotFoundException(RENTAL_NOT_FOUND));

        int change = payment - rentalToPay.getPrice();

        if (change >= 0) rentalToPay.setPaid(true);
        else rentalToPay.setPrice(change * -1);
        this.repository.save(rentalToPay);
        return change;
    }
}
