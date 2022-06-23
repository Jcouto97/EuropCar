package europcar.project.controllers;

import europcar.project.command.RentalsDto;
import europcar.project.services.RentalServiceI;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/rentals")
@AllArgsConstructor
public class RentalsController {
    private RentalServiceI rentalServiceI;

    @GetMapping
    public ResponseEntity<List<RentalsDto>> getRentals() {
        return new ResponseEntity<>(this.rentalServiceI.getRentals(), HttpStatus.OK);
    }
}
