package europcar.project.services;

import europcar.project.command.RentalsDto;
import europcar.project.converters.RentalsConverter;
import europcar.project.persistence.repositories.RentalsJpaRepositoryI;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RentalsServiceImp implements RentalServiceI {
    private RentalsJpaRepositoryI repository;
    private RentalsConverter converter;

    @Override
    public List<RentalsDto> getRentals() {
        return this.converter.convertEntityListToDtoList(this.repository.findAll());
    }
}
