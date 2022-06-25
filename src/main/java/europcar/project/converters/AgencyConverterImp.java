package europcar.project.converters;

import europcar.project.command.AgencyDto;
import europcar.project.command.AgencyUpdateDto;
import europcar.project.persistence.models.Agency;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class AgencyConverterImp implements DtoConvertersI<Agency, AgencyDto, AgencyUpdateDto> {

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
    public AgencyUpdateDto entityToUpdateDto(Agency agency) {
        return null;
    }

    @Override
    public Agency updateDtoToEntity(AgencyUpdateDto agencyUpdateDto, Agency agency) {
        return null;
    }

    @Override
    public List<AgencyDto> convertEntityListToDtoList(List<Agency> agencies) {

        return agencies.stream().map(agency -> this.MODEL_MAPPER.map(agency, AgencyDto.class)).toList();
    }

    @Override
    public List<Agency> convertDtoListToEntityList(List<AgencyDto> agencyDtos) {
        return null;
    }
}
