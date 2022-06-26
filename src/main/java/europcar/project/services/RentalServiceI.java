package europcar.project.services;

import europcar.project.command.RentalDto;

import java.util.List;

public interface RentalServiceI {
    List<RentalDto> getRentals();

    RentalDto getRentalById(Long id);

    List<RentalDto> getRentalsByUser(String userId);

    List<RentalDto> getRentalsByVehicle(Long vehicleId);

    void deleteRental(Long id);

    RentalDto rentVehicle(Long userId, Long vehicleId, Long agencyId);

    RentalDto returnVehicle(Long userId);

    int payRent(Long id, int payment);
}
