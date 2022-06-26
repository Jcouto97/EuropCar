package europcar.project.converters;

import europcar.project.command.AtributeDto;
import europcar.project.persistence.models.VehicleAtributes.Brand;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class BrandConverterImp implements DtoConvertersI<Brand, AtributeDto> {
    private ModelMapper MODEL_MAPPER;

    @Override
    public AtributeDto entityToDto(Brand atribute) {
        return this.MODEL_MAPPER.map(atribute, AtributeDto.class);
    }

    @Override
    public Brand dtoToEntity(AtributeDto atributeDto) {
        return this.MODEL_MAPPER.map(atributeDto, Brand.class);
    }

    @Override
    public List<AtributeDto> entityListToDtoList(List<Brand> atributes) {
        return atributes.stream()
                .map(at -> this.MODEL_MAPPER.map(at, AtributeDto.class))
                .toList();
    }
}
