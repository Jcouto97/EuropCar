package europcar.project.controllers;

import europcar.project.command.RentalDto;
import europcar.project.command.RentalUpdateDto;
import europcar.project.services.RentalServiceI;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public RentalDto getRental(@PathVariable("id") Long id) {
        return this.rentalServiceI.getRental(id);
    }

    @PostMapping
    public RentalDto addRental(@RequestBody RentalDto rentalDto) {
        return this.rentalServiceI.addRental(rentalDto);
    }

    @DeleteMapping("/{id}")
    public void deleteRental(@PathVariable("id") Long id) {
        this.rentalServiceI.deleteRental(id);
    }

    @PutMapping("/{id}")
    public RentalDto updateRental(@PathVariable("id") Long id, @RequestBody RentalDto rentalDto) {
        return this.rentalServiceI.updateRental(id, rentalDto);
    }
}
