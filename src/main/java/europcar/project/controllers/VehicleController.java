package europcar.project.controllers;

import europcar.project.command.VehicleDto;
import europcar.project.persistence.models.Vehicle;
import europcar.project.services.VehicleServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/vehicles")

public class VehicleController {

    private final VehicleServiceI vehicleServiceI;

@Autowired
    public VehicleController(VehicleServiceI vehicleServiceI) {
        this.vehicleServiceI = vehicleServiceI;
    }
    @GetMapping
    public List<Vehicle> getVehicles() {return this.vehicleServiceI.getVehicles();}

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDto> getVehicleById(@PathVariable("id") Long id){
    VehicleDto vehicleDto = this.vehicleServiceI.getVehicleById(id);

    if(vehicleDto == null) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(vehicleDto, HttpStatus.OK);
    }
}
