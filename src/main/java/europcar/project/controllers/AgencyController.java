package europcar.project.controllers;

import europcar.project.command.AgencyDto;
import europcar.project.persistence.models.Agency;
import europcar.project.services.AgencyServiceI;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/agencies")
public class AgencyController {
    private AgencyServiceI agencyServiceI;

    @GetMapping
    public List<AgencyDto> getAgenciesList(){
        return this.agencyServiceI.getAgenciesList();
    }

    @GetMapping(path = "/{AgencyId}")
    public AgencyDto getAgencyById(@PathVariable ("AgencyId") Long agencyId){
        return this.agencyServiceI.getAgencyById(agencyId);
    }

    @PostMapping
    public AgencyDto createAgency(@RequestBody Agency agency){
        return this.agencyServiceI.createAgency(agency);
    }



}
