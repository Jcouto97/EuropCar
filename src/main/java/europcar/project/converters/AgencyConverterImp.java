package europcar.project.converters;

import europcar.project.command.AgencyDto;
import europcar.project.persistence.models.Agency;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class AgencyConverterImp implements DtoConvertersI<Agency, AgencyDto> {

    private final ModelMapper MODEL_MAPPER;

    @Override
    public AgencyDto entityToDto(Agency agency) {
        return this.MODEL_MAPPER.map(agency, AgencyDto.class);
    }

    @Override
    public Agency dtoToEntity(AgencyDto agencyDto) {

        return this.MODEL_MAPPER.map(agencyDto, Agency.class);
    }

    @Override
    public List<AgencyDto> entityListToDtoList(List<Agency> agencies) {

        return agencies.stream().map(agency -> this.MODEL_MAPPER.map(agency, AgencyDto.class)).toList();
    }
}
