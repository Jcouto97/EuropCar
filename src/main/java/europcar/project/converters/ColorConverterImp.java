package europcar.project.converters;

import europcar.project.command.AtributeDto;
import europcar.project.persistence.models.VehicleAtributes.Color;
import europcar.project.persistence.models.VehicleAtributes.Type;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class ColorConverterImp implements DtoConvertersI<Color, AtributeDto> {
    private ModelMapper MODEL_MAPPER;

    @Override
    public AtributeDto entityToDto(Color atribute) {
        return this.MODEL_MAPPER.map(atribute, AtributeDto.class);
    }

    @Override
    public Color dtoToEntity(AtributeDto atributeDto) {
        return this.MODEL_MAPPER.map(atributeDto, Color.class);
    }

    @Override
    public List<AtributeDto> entityListToDtoList(List<Color> atributes) {
        return atributes.stream()
                .map(at -> this.MODEL_MAPPER.map(at, AtributeDto.class))
                .toList();
    }
}