package europcar.project.services;

import europcar.project.command.ModelDto;
import europcar.project.persistence.models.Model;

public interface ModelServiceI {

    ModelDto getModelByName(String model);

    ModelDto addModel(ModelDto modelDto);
}
