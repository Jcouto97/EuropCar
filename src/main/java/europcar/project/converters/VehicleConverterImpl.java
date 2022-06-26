package europcar.project.converters;

import europcar.project.command.VehicleDto;
import europcar.project.command.VehicleUpdateDto;
import europcar.project.persistence.models.Vehicle;
import org.modelmapper.ModelMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class VehicleConverterImpl implements DtoConvertersI<Vehicle, VehicleDto>, UpdateDtoConverterI<Vehicle, VehicleUpdateDto> {
    private final ModelMapper MODEL_MAPPER;

    @Override
    public VehicleDto entityToDto(Vehicle vehicle) {
        return MODEL_MAPPER.map(vehicle, VehicleDto.class);
    }

    @Override
    public Vehicle dtoToEntity(VehicleDto vehicleDto) {
        return MODEL_MAPPER.map(vehicleDto, Vehicle.class);
    }

    public VehicleUpdateDto entityToUpdateDto(Vehicle vehicle) {
        return MODEL_MAPPER.map(vehicle, VehicleUpdateDto.class);
    }

    public Vehicle updateDtoToEntity(VehicleUpdateDto update, Vehicle vehicle) {
        this.MODEL_MAPPER.getConfiguration().setSkipNullEnabled(true);
        this.MODEL_MAPPER.map(update, vehicle);
        return vehicle;
    }

    @Override
    public List<VehicleDto> entityListToDtoList(List<Vehicle> vehicles) {
        return vehicles.stream()
                .map(vehicle -> MODEL_MAPPER.map(vehicle, VehicleDto.class))
                .collect(Collectors.toList());
    }
}
