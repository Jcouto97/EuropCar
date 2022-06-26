package europcar.project.converters;

import europcar.project.command.RentalDto;
import europcar.project.persistence.models.Rental;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class RentalConverterImp implements DtoConvertersI<Rental, RentalDto> {
    private final ModelMapper MODEL_MAPPER;

    @Override
    public RentalDto entityToDto(Rental rental) {
        return this.MODEL_MAPPER.map(rental, RentalDto.class);
    }

    @Override
    public Rental dtoToEntity(RentalDto rentalDto) {
        return this.MODEL_MAPPER.map(rentalDto, Rental.class);
    }

    @Override
    public List<RentalDto> entityListToDtoList(List<Rental> rentals) {
        return rentals.stream()
                .map(rent -> this.MODEL_MAPPER.map(rent, RentalDto.class))
                .toList();
    }
}
