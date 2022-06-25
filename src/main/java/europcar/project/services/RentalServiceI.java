package europcar.project.services;

import europcar.project.command.RentalDto;
import europcar.project.command.RentalDto2;
import europcar.project.command.RentalUpdateDto;
import europcar.project.persistence.models.Rental;

import java.util.List;

public interface RentalServiceI {
    List<RentalDto> getRentals();

    RentalDto addRental(RentalDto rentalsDto);

    RentalDto getRentalById(Long id);

    void deleteRental(Long id);

    RentalUpdateDto updateRental(Long id, RentalUpdateDto rentalUpdateDto);

//    List<RentalDto> getRentalByUser(Long id);

    RentalDto2 rentVehicle(Long userId, Long vehicleId);

    RentalDto2 returnVehicle(Long userId);


}
