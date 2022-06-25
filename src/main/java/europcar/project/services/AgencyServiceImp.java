package europcar.project.services;

import europcar.project.command.AgencyDto;
import europcar.project.converters.AgencyConverterImp;
import europcar.project.converters.UserConverterImp;
import europcar.project.persistence.models.Agency;
import europcar.project.persistence.repositories.AgencyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AgencyServiceImp implements AgencyServiceI{

    private AgencyRepository agencyRepository;
    private AgencyConverterImp agencyConverterImp;

    @Override
    public List<AgencyDto> getAgenciesList() {
        return this.agencyConverterImp.convertEntityListToDtoList(this.agencyRepository.findAll());
    }

    @Override
    public AgencyDto createAgency(Agency agency) {
        Agency agencySaved = this.agencyRepository.save(agency);

        return this.agencyConverterImp.entityToDto(agencySaved);
    }

    @Override
    public AgencyDto getAgencyById(Long agencyId) {

        Agency agency = this.agencyRepository.findById(agencyId).orElse(null);

        return this.agencyConverterImp.entityToDto(agency);
    }

}
