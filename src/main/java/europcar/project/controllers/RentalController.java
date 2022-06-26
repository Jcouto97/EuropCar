package europcar.project.controllers;

import europcar.project.command.RentalDto;
import europcar.project.services.RentalServiceI;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/rentals")
@AllArgsConstructor
public class RentalController {
    private RentalServiceI rentalServiceI;

    @GetMapping
    public List<RentalDto> getRentals() {
        return this.rentalServiceI.getRentals();
    }

    @GetMapping("/{id}")
    public RentalDto getRentalById(@PathVariable("id") Long id) {
        return this.rentalServiceI.getRentalById(id);
    }

    @GetMapping("/user/{id}")
    public List<RentalDto> getRentsByUser(@PathVariable("id") String user) {
        return this.rentalServiceI.getRentalsByUser(user);
    }

    @GetMapping("/vehicle/{id}")
    public List<RentalDto> getRentsByVehicle(@PathVariable("id") Long vehicleId) {
        return this.rentalServiceI.getRentalsByVehicle(vehicleId);
    }

    @DeleteMapping("/{id}")
    public void deleteRental(@PathVariable("id") Long id) {
        this.rentalServiceI.deleteRental(id);
    }

    @PostMapping("/rent")
    public RentalDto rentVehicle(@RequestParam(value = "user") Long userId,
                                 @RequestParam(value = "vehicle") Long vehicleId,
                                 @RequestParam(value = "agency") Long agencyId) {
        return this.rentalServiceI.rentVehicle(userId, vehicleId, agencyId);
    }

    @PutMapping("/return/user/{id}")
    public RentalDto returnVehicle(@PathVariable("id") Long userId) {
        return this.rentalServiceI.returnVehicle(userId);
    }

    @PutMapping("/pay/user/{id}")
    public ResponseEntity<String> payRent(@PathVariable("id") Long userId,
                                          @Valid @RequestBody int payment) {
        if (payment <= 0) return new ResponseEntity<>("Value not allowed", HttpStatus.BAD_REQUEST);

        int change = this.rentalServiceI.payRent(userId, payment);
        return change >= 0 ?
                new ResponseEntity<>("The rent is payed. You receive " + change + "€ change", HttpStatus.OK) :
                new ResponseEntity<>("It's still missing " + (change * -1) + "€", HttpStatus.EXPECTATION_FAILED);
    }
}
