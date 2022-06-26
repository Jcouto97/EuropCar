package europcar.project.controllers;

import europcar.project.command.VehicleDto;
import europcar.project.command.VehicleUpdateDto;
import europcar.project.services.VehicleServiceI;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/vehicles")
@AllArgsConstructor

public class VehicleController {

    private final VehicleServiceI vehicleServiceI;

    @GetMapping
    public List<VehicleDto> getVehicles() {
        return this.vehicleServiceI.getVehicles();
    }

    @GetMapping("/{id}")
    public VehicleDto getVehicleById(@PathVariable("id") Long id) {
        return this.vehicleServiceI.getVehicleById(id);
    }

    @GetMapping("bybrand/{brand}")
    public List<VehicleDto> getVehicleByBrand(@PathVariable("brand") Long brandId) {
        return this.vehicleServiceI.getVehicleByBrand(brandId);
    }

    @PostMapping
    public VehicleDto addVehicle(@Valid @RequestBody VehicleDto vehicleDto) {
        return this.vehicleServiceI.addVehicle(vehicleDto);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable("id") Long id) {
        this.vehicleServiceI.deleteVehicle(id);
    }

    @PutMapping("/{id}")
    public VehicleDto updateVehicle(@PathVariable("id") Long id, @Valid @RequestBody VehicleUpdateDto vehicleUpdateDto) {
        return this.vehicleServiceI.updateVehicle(id, vehicleUpdateDto);
    }
}
