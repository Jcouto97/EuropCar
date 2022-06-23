package europcar.project.converters;

import europcar.project.command.RentalDto;
import europcar.project.persistence.models.Rental;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class RentalConverter implements DtoConvertersI<Rental, RentalDto> {
    private final ModelMapper MODEL_MAPPER;

    @Override
    public RentalDto entityToDto(Rental rentals) {
        return null;
    }

    @Override
    public Rental dtoToEntity(RentalDto rentalsDto) {
        return null;
    }

    public RentalDto entityToUpdateDto(Rental rentals) {
        return null;
    }

    public Rental updateDtoToEntity(RentalDto rentalDto, Rental rental) {
        this.MODEL_MAPPER.getConfiguration().setSkipNullEnabled(true);
        this.MODEL_MAPPER.map(rentalDto, rental);
        return rental;
    }

    @Override
    public List<RentalDto> convertEntityListToDtoList(List<Rental> rentals) {
        return null;
    }

    @Override
    public List<Rental> convertDtoListToEntityList(List<RentalDto> rentalsDtos) {
        return null;
    }
}
