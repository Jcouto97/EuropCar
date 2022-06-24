package europcar.project.controllers;

import europcar.project.command.ModelDto;
import europcar.project.command.VehicleDto;
import europcar.project.command.VehicleUpdateDto;
import europcar.project.exceptions.ModelNotFoundException;
import europcar.project.persistence.models.Model;
import europcar.project.persistence.models.Vehicle;
import europcar.project.services.ModelServiceI;
import europcar.project.services.VehicleServiceI;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static europcar.project.exceptions.ExceptionMessages.ExceptionMessages.MODEL_NOT_FOUND;

@RestController
@RequestMapping("api/v1/vehicles")
@AllArgsConstructor

public class VehicleController {

    private final VehicleServiceI vehicleServiceI;
    private final ModelServiceI modelServiceI;

    @GetMapping
    public List<Vehicle> getVehicles() {
        return this.vehicleServiceI.getVehicles();
    }

    @GetMapping("byId/{id}")
    public ResponseEntity<VehicleDto> getVehicleById(@PathVariable("id") Long id) throws Throwable {
    VehicleDto vehicleDto = this.vehicleServiceI.getVehicleById(id);
        return new ResponseEntity<>(vehicleDto, HttpStatus.OK);
    }

    @GetMapping("byModel/{model}")
    public ResponseEntity<List <VehicleDto>> getVehicleByModel(@PathVariable("model") String model) throws Throwable {
        ModelDto modelDto = this.modelServiceI.getModelByName(model);
        List <VehicleDto> vehicleDto = this.vehicleServiceI.getVehicleByModel(modelDto);
        return new ResponseEntity<>(vehicleDto, HttpStatus.OK);
    }

    @GetMapping("{type}")
    public ResponseEntity<List <VehicleDto>> getVehicleByType(@PathVariable("type") String type) throws Throwable {
        List <VehicleDto> vehicleDto = this.vehicleServiceI.getVehicleByType(type);
        return new ResponseEntity<>(vehicleDto, HttpStatus.OK);
    }



    @PostMapping //("/{id}")
    public ResponseEntity<VehicleDto> addNewVehicle(@PathVariable("id") Long id, @RequestBody VehicleDto requestVehicleDto) {
        //testar com o id do modelo; não está terminado
        VehicleDto responseVehicleDto = this.vehicleServiceI.addVehicle(requestVehicleDto);
        return new ResponseEntity<>(responseVehicleDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleDto> updateVehicle(@PathVariable("id") Long id, @Valid @RequestBody VehicleUpdateDto vehicleUpdateDto) {
        VehicleDto vehicleUpdated = this.vehicleServiceI.updateVehicle(id, vehicleUpdateDto);
        return new ResponseEntity<>(vehicleUpdated, HttpStatus.OK);

    }


   @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable("id") Long id) {
       this.vehicleServiceI.deleteVehicle(id);
       return  new ResponseEntity<>("Vehicle with the ID " + id + " was removed from the database.", HttpStatus.OK);
   }

}
