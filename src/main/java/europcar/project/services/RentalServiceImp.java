package europcar.project.services;

import europcar.project.command.RentalDto;
import europcar.project.command.RentalUpdateDto;
import europcar.project.converters.RentalConverter;
import europcar.project.exceptions.RentalNotFoundException;
import europcar.project.exceptions.RentingException;
import europcar.project.exceptions.UserNotFoundException;
import europcar.project.exceptions.VehicleNotFoundException;
import europcar.project.persistence.models.Rental;
import europcar.project.persistence.models.User;
import europcar.project.persistence.models.Vehicle;
import europcar.project.persistence.repositories.RentalsJpaRepositoryI;
import europcar.project.persistence.repositories.UserRepository;
import europcar.project.persistence.repositories.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static europcar.project.exceptions.ExceptionMessages.ExceptionMessages.*;

@Service
@AllArgsConstructor
public class RentalServiceImp implements RentalServiceI {
    private RentalsJpaRepositoryI repository;
    private RentalConverter converter;
    private UserRepository userRepository;
    private VehicleRepository vehicleRepository;

    @Override
    public List<RentalDto> getRentals() {
        return this.converter.convertEntityListToDtoList(this.repository.findAll());
    }

    public RentalDto getRentalById(Long id) {
        return this.converter.entityToDto(
                this.repository.findById(id).orElseThrow(() ->
                        new RentalNotFoundException(RENTAL_NOT_FOUND)));
    }

//    public List<RentalDto> getRentalByUser(Long id) {
//        return this.converter.convertEntityListToDtoList(
//                this.repository.findByUser(id));
//    }

    @Override
    public RentalDto addRental(RentalDto rentalsDto) {
        return this.converter.entityToDto(
                this.repository.save(
                        this.converter.dtoToEntity(rentalsDto)));
    }

    @Override
    public void deleteRental(Long id) {
        this.repository.delete(
                this.repository.findById(id)
                        .orElseThrow(() -> new RentalNotFoundException(RENTAL_NOT_FOUND)));
    }

    @Override
    public RentalUpdateDto updateRental(Long id, RentalUpdateDto rentalUpdateDto) {
        Rental rental = this.repository.findById(id).orElseThrow(() ->
                new RentalNotFoundException(RENTAL_NOT_FOUND));
        Rental updatedRental = this.converter.updateDtoToEntity(rentalUpdateDto, rental);
        return this.converter.entityToUpdateDto(
                this.repository.save(updatedRental));
    }

    public RentalDto rentVehicle(Long userId, Long vehicleId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
        if (user.isRenting()) throw new RentingException(USER_RENTING);
        user.setRenting(true);

        Vehicle vehicle = this.vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new VehicleNotFoundException(VEHICLE_NOT_FOUND));
        if (vehicle.isRented()) throw new RentingException(String.format(VEHICLE_RENTING));
        vehicle.setRented(true);

        Rental rental = Rental.builder()
                .user(user)
                .vehicle(vehicle)
                .rentDate(LocalDate.now())
                .missingFuelPrice(2)
                .build();
        user.addRental(rental);
        vehicle.addRental(rental);
        return this.converter.entityToDto(this.repository.save(rental));
    }

    public void returnVehicle(Long userId, Long vehicleId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
        Rental rental = user.getRentals().stream()
                .filter(rent -> rent.getVehicle().getId().equals(vehicleId))
                .findFirst().orElseThrow(() -> new VehicleNotFoundException(VEHICLE_NOT_FOUND));

        rental.setReturnDate(LocalDate.now());
        this.repository.save(rental);
    }
}
