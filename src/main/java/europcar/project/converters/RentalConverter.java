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
    public RentalDto entityToDto(Rental rental) {
        return this.MODEL_MAPPER.map(rental, RentalDto.class);
    }

    @Override
    public Rental dtoToEntity(RentalDto rentalDto) {
        return this.MODEL_MAPPER.map(rentalDto, Rental.class);
    }

    public Rental dtoToEntity(RentalDto rentalDto, Rental rental) {
        this.MODEL_MAPPER.getConfiguration().setSkipNullEnabled(true);
        this.MODEL_MAPPER.map(rentalDto, rental);
        return rental;
    }

    @Override
    public List<RentalDto> convertEntityListToDtoList(List<Rental> rentals) {
        return rentals.stream()
                .map(rent -> this.MODEL_MAPPER.map(rent, RentalDto.class))
                .toList();
    }

    @Override
    public List<Rental> convertDtoListToEntityList(List<RentalDto> rentalDtos) {
        return rentalDtos.stream()
                .map(rentD -> this.MODEL_MAPPER.map(rentD, Rental.class))
                .toList();
    }
}