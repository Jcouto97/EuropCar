package europcar.project.services;

import europcar.project.command.RentalsDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RentalServiceI {
    List<RentalsDto> getRentals();
}
