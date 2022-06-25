package europcar.project.services;

import europcar.project.command.AgencyDto;
import europcar.project.persistence.models.Agency;

import java.util.List;

public interface AgencyServiceI {
    List<AgencyDto> getAgenciesList();


    AgencyDto createAgency(Agency agency);
}
