package europcar.project.services;

import europcar.project.command.AgencyDto;
import europcar.project.converters.AgencyConverterImp;
import europcar.project.exceptions.AgencyNotFoundException;
import europcar.project.exceptions.AtributeAttachedException;
import europcar.project.persistence.models.Agency;
import europcar.project.persistence.repositories.AgencyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static europcar.project.exceptions.ExceptionMessages.ExceptionMessages.AGENCY_NOT_FOUND;
import static europcar.project.exceptions.ExceptionMessages.ExceptionMessages.ATRIBUTE_ATTACHED;

@Service
@AllArgsConstructor
public class AgencyServiceImp implements AgencyServiceI {
    private AgencyRepository agencyRepository;
    private AgencyConverterImp agencyConverterImp;

    @Override
    public List<AgencyDto> getAgenciesList() {
        return this.agencyConverterImp.entityListToDtoList(this.agencyRepository.findAll());
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

    public void deleteAgency(Long id) {
               Agency agency = this.agencyRepository.findById(id).orElseThrow(() -> new AgencyNotFoundException(AGENCY_NOT_FOUND));

        if (!agency.getRentals().isEmpty()) throw new AtributeAttachedException(ATRIBUTE_ATTACHED);

        this.agencyRepository.delete(agency);
    }
}
