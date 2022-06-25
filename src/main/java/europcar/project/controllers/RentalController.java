package europcar.project.controllers;

import europcar.project.command.RentalDto;
import europcar.project.command.RentalUpdateDto;
import europcar.project.persistence.models.Rental;
import europcar.project.services.RentalServiceI;
import lombok.AllArgsConstructor;
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

//    @GetMapping("clientid/{id}")
//    public List<RentalDto> getRentalsByUser(@PathVariable("id") Long id) {
//        return this.rentalServiceI.getRentalByUser(id);
//    }

    @PostMapping
    public RentalDto addRental(@Valid @RequestBody RentalDto rentalDto) {
        return this.rentalServiceI.addRental(rentalDto);
    }

    @DeleteMapping("/{id}")
    public void deleteRental(@PathVariable("id") Long id) {
        this.rentalServiceI.deleteRental(id);
    }

    @PutMapping("/{id}")
    public RentalUpdateDto updateRental(@PathVariable("id") Long id, @Valid @RequestBody RentalUpdateDto rentalUpdateDto) {
        return this.rentalServiceI.updateRental(id, rentalUpdateDto);
    }

    @PostMapping("/rent/user/{userId}/vehicle/{vehicleId}")
    public RentalDto rentVehicle(@PathVariable("userId") Long userId,
                                 @PathVariable("vehicleId") Long vehicleId) {
        return this.rentalServiceI.rentVehicle(userId, vehicleId);
    }

    @PostMapping("/return/user/{userId}/vehicle/{vehicleId}")
    public RentalDto returnVehicle(@PathVariable("userId") Long userId) {
        return this.rentalServiceI.returnVehicle(userId);
    }
}
