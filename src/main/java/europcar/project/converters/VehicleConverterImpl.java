package europcar.project.converters;

import europcar.project.command.VehicleDto;
import europcar.project.command.VehicleUpdateDto;
import europcar.project.persistence.models.Vehicle;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class VehicleConverterImpl implements ConvertersI <Vehicle, VehicleDto, VehicleUpdateDto> {

    private final static ModelMapper modelMapper = new ModelMapper();
    @Override
    public VehicleDto entityToDto(Vehicle vehicle) {
        return modelMapper.map(vehicle, VehicleDto.class);
    }

    @Override
    public Vehicle dtoToEntity(VehicleDto vehicleDto) {
        return modelMapper.map(vehicleDto, Vehicle.class);
    }

    @Override
    public VehicleUpdateDto entityToUpdateDto(Vehicle vehicle) {
        return modelMapper.map(vehicle, VehicleUpdateDto.class);
    }

    @Override
    public Vehicle updateDtoToEntity(VehicleUpdateDto update) {
        return modelMapper.map(update, Vehicle.class);
    }

    @Override
    public List<VehicleDto> convertEntityListToDtoList(List<Vehicle> vehicles) {
      return vehicles.stream()
               .map(vehicle -> modelMapper.map(vehicle, VehicleDto.class))
              .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> convertDtoListToEntityList(List<VehicleDto> vehicleDtos) {
        return vehicleDtos.stream()
                .map(vehicle -> modelMapper.map(vehicle, Vehicle.class))
                .collect(Collectors.toList());
    }
}
