package europcar.project.services;

import europcar.project.command.RentalDto;
import europcar.project.converters.RentalConverter;
import europcar.project.exceptions.RentalNotFoundException;
import europcar.project.persistence.models.Rental;
import europcar.project.persistence.repositories.RentalsJpaRepositoryI;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static europcar.project.exceptions.ExceptionMessages.ExceptionMessages.RENTAL_NOT_FOUND;

@Service
@AllArgsConstructor
public class RentalServiceImp implements RentalServiceI {
    private RentalsJpaRepositoryI repository;
    private RentalConverter converter;

    @Override
    public List<RentalDto> getRentals() {
        return this.converter.convertEntityListToDtoList(this.repository.findAll());
    }

    public RentalDto getRental(Long id) {
        return this.converter.entityToDto(
                this.repository.findById(id).orElseThrow(() ->
                        new RentalNotFoundException(RENTAL_NOT_FOUND)));
    }

    @Override
    public RentalDto addRental(RentalDto rentalsDto) {
        return this.converter.entityToDto(
                this.repository.save(
                        this.converter.dtoToEntity(rentalsDto)));
    }

    @Override
    public void deleteRental(Long id) {
        this.repository.delete(
                this.repository.findById(id)
                        .orElseThrow(() -> new RentalNotFoundException(RENTAL_NOT_FOUND)));
    }

    @Override
    public RentalDto updateRental(Long id, RentalDto rentalDto) {
        Rental rental = this.repository.findById(id).orElseThrow(() ->
                new RentalNotFoundException(RENTAL_NOT_FOUND));
        Rental updatedRental = this.converter.dtoToEntity(rentalDto, rental);
        return this.converter.entityToDto(
                this.repository.save(updatedRental));
    }
}
