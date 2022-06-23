package europcar.project.converters;

import europcar.project.command.RentalsDto;
import europcar.project.command.RentalsUpdateDto;
import europcar.project.persistence.models.Rentals;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class RentalsConverter implements ConvertersI<Rentals, RentalsDto, RentalsUpdateDto> {

    @Override
    public RentalsDto entityToDto(Rentals rentals) {
        return null;
    }

    @Override
    public Rentals dtoToEntity(RentalsDto rentalsDto) {
        return null;
    }

    @Override
    public RentalsUpdateDto entityToUpdateDto(Rentals rentals) {
        return null;
    }

    @Override
    public Rentals updateDtoToEntity(RentalsUpdateDto update) {
        return null;
    }

    @Override
    public List<RentalsDto> convertEntityListToDtoList(List<Rentals> rentals) {
        return null;
    }

    @Override
    public List<Rentals> convertDtoListToEntityList(List<RentalsDto> rentalsDtos) {
        return null;
    }
}
