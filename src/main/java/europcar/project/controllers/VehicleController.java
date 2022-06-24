package europcar.project.controllers;

import europcar.project.command.VehicleDto;
import europcar.project.persistence.models.Vehicle;
import europcar.project.services.VehicleServiceI;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/vehicles")
@AllArgsConstructor

public class VehicleController {

    private final VehicleServiceI vehicleServiceI;

    @GetMapping
    public List<Vehicle> getVehicles() {
        return this.vehicleServiceI.getVehicles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDto> getVehicleById(@PathVariable("id") Long id) throws Throwable {
    VehicleDto vehicleDto = this.vehicleServiceI.getVehicleById(id);

        if (vehicleDto == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(vehicleDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VehicleDto> addNewVehicle(@RequestBody VehicleDto requestVehicleDto) {
        VehicleDto responseVehicleDto = this.vehicleServiceI.addVehicle(requestVehicleDto);
        return new ResponseEntity<>(responseVehicleDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleDto> updateVehicle(@PathVariable("id") Long id, @RequestBody VehicleDto)

    @DeleteMapping


}
