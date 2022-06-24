package europcar.project.controllers;

import europcar.project.command.ModelDto;
import europcar.project.command.VehicleDto;
import europcar.project.services.ModelServiceI;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/models")
@AllArgsConstructor
public class ModelController {
    private ModelServiceI modelServiceI;

    @PostMapping
    public ResponseEntity<ModelDto> addNewModel(@RequestBody ModelDto modelDto) {
        ModelDto responseModelDto = this.modelServiceI.addModel(modelDto);
        return new ResponseEntity<>(responseModelDto, HttpStatus.OK);
    }


}
