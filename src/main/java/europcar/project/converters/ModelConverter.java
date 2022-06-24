package europcar.project.converters;


import europcar.project.command.ModelDto;
import europcar.project.command.ModelUpdateDto;
import europcar.project.command.RentalDto;
import europcar.project.persistence.models.Model;
import europcar.project.persistence.models.Rental;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ModelConverter implements DtoConvertersI <Model, ModelDto, ModelUpdateDto> {

    private final ModelMapper MODEL_MAPPER;
    @Override
    public ModelDto entityToDto(Model model) {
            return this.MODEL_MAPPER.map(model, ModelDto.class);
    }

    @Override
    public Model dtoToEntity(ModelDto modelDto) {
        return this.MODEL_MAPPER.map(modelDto, Model.class);
    }

    @Override
    public ModelUpdateDto entityToUpdateDto(Model model) {
        return null;
    }

    @Override
    public Model updateDtoToEntity(ModelUpdateDto modelUpdateDto, Model model) {
        return null;
    }

    @Override
    public List<ModelDto> convertEntityListToDtoList(List<Model> models) {
        return null;
    }

    @Override
    public List<Model> convertDtoListToEntityList(List<ModelDto> modelDtos) {
        return null;
    }
}
