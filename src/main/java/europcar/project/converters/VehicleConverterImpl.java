package europcar.project.converters;

import europcar.project.command.VehicleDto;
import europcar.project.command.VehicleUpdateDto;
import europcar.project.persistence.models.Vehicle;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VehicleConverterImpl implements ConvertersI <Vehicle, VehicleDto, VehicleUpdateDto> {

    @Override
    public VehicleDto entityToDto(Vehicle vehicle) {
        return null;
    }

    @Override
    public Vehicle dtoToEntity(VehicleDto vehicleDto) {
        return null;
    }

    @Override
    public VehicleUpdateDto entityToUpdateDto(Vehicle vehicle) {
        return null;
    }

    @Override
    public Vehicle updateDtoToEntity(VehicleUpdateDto update) {
        return null;
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
