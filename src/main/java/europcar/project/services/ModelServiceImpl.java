package europcar.project.services;

import europcar.project.command.*;
import europcar.project.converters.ModelConverter;
import europcar.project.exceptions.ModelNotFoundException;
import europcar.project.exceptions.UserNotFoundException;
import europcar.project.persistence.models.Model;
import europcar.project.persistence.models.Vehicle;
import europcar.project.persistence.repositories.ModelJpaRepository;
import lombok.AllArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;

import static europcar.project.exceptions.ExceptionMessages.ExceptionMessages.MODEL_NOT_FOUND;
import static europcar.project.exceptions.ExceptionMessages.ExceptionMessages.VEHICLE_NOT_FOUND;

@Service
@AllArgsConstructor
public class ModelServiceImpl implements ModelServiceI {

    ModelJpaRepository modelJpaRepository;
    private ModelConverter modelConverter;

    @Override
    public ModelDto getModelByName(String name) {
      return modelConverter.entityToDto(this.modelJpaRepository.findByName(name)
                        .stream()
                        .findAny()
                       .orElseThrow(() -> new ModelNotFoundException(MODEL_NOT_FOUND)));
    }

    @Override
    public ModelDto addModel(ModelDto modelDto) {
        Model model = modelConverter.dtoToEntity(modelDto);
        return modelConverter.entityToDto(modelJpaRepository.save(model));
    }

}
