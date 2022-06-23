package europcar.project.services;

import europcar.project.command.RentalsDto;
import europcar.project.converters.RentalsConverter;
import europcar.project.persistence.models.Rentals;
import europcar.project.persistence.repositories.RentalsJpaRepositoryI;
import lombok.AllArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.This;
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

    @Override
    public RentalsDto addRental(RentalsDto rentalsDto) {
        return this.converter.entityToDto(
                this.repository.save(
                        this.converter.dtoToEntity(rentalsDto)));
    }
}
