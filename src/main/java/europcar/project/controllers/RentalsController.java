package europcar.project.controllers;

import europcar.project.services.RentalServiceI;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/rentals")
@AllArgsConstructor
public class RentalsController {
    private RentalServiceI rentalServiceI;


    @GetMapping("/{name}")
    public String getString(@PathVariable("name") String name){
        return  rentalServiceI.getString() + name;
    }

    @PostMapping
    public String postString(@RequestBody String name){
        return rentalServiceI.postString(name);
    }
}
