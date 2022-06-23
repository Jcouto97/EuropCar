package europcar.project.converters;

import europcar.project.command.VehicleDto;
import europcar.project.command.VehicleUpdateDto;
import europcar.project.persistence.models.Vehicle;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class VehicleConverterImpl implements DtoConvertersI<Vehicle, VehicleDto> {
    private final ModelMapper MODEL_MAPPER;

    @Override
    public VehicleDto entityToDto(Vehicle vehicle) {
        return null;
    }

    @Override
    public Vehicle dtoToEntity(VehicleDto vehicleDto) {
        return null;
    }

    public VehicleUpdateDto entityToUpdateDto(Vehicle vehicle) {
        return null;
    }

    public Vehicle updateDtoToEntity(VehicleUpdateDto update, Vehicle vehicle) {
        this.MODEL_MAPPER.getConfiguration().setSkipNullEnabled(true);
        this.MODEL_MAPPER.map(update, vehicle);
        return vehicle;
    }

    @Override
    public List<VehicleDto> convertEntityListToDtoList(List<Vehicle> vehicles) {
        return null;
    }

    @Override
    public List<Vehicle> convertDtoListToEntityList(List<VehicleDto> vehicleDtos) {
        return null;
    }
}
