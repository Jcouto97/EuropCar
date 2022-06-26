package europcar.project.converters;

import europcar.project.command.AtributeDto;
import europcar.project.persistence.models.VehicleAtributes.Brand;
import europcar.project.persistence.models.VehicleAtributes.Type;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class TypeConverterImp implements DtoConvertersI<Type, AtributeDto> {
    private ModelMapper MODEL_MAPPER;

    @Override
    public AtributeDto entityToDto(Type atribute) {
        return this.MODEL_MAPPER.map(atribute, AtributeDto.class);
    }

    @Override
    public Type dtoToEntity(AtributeDto atributeDto) {
        return this.MODEL_MAPPER.map(atributeDto, Type.class);
    }

    @Override
    public List<AtributeDto> entityListToDtoList(List<Type> atributes) {
        return atributes.stream()
                .map(at -> this.MODEL_MAPPER.map(at, AtributeDto.class))
                .toList();
    }
}

