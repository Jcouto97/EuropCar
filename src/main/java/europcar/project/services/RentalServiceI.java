package europcar.project.services;

import europcar.project.command.RentalDto;
import europcar.project.command.RentalUpdateDto;

import java.util.List;

public interface RentalServiceI {
    List<RentalDto> getRentals();

    RentalDto addRental(RentalDto rentalsDto);

    RentalDto getRental(Long id);

    void deleteRental(Long id);

    RentalUpdateDto updateRental(Long id, RentalUpdateDto rentalUpdateDto);
}
