package europcar.project.services;

import europcar.project.command.VehicleDto;
import europcar.project.converters.VehicleConverterImpl;
import europcar.project.exceptions.VehicleNotFoundException;
import europcar.project.persistence.models.Vehicle;
import europcar.project.persistence.repositories.JpaRepositoryI;
import europcar.project.persistence.repositories.VehicleJpaRepositoryI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

@RequiredArgsConstructor
public class VehicleServiceImp implements VehicleServiceI{

    private final VehicleJpaRepositoryI vehicleJpaRepository;
    private final VehicleConverterImpl vehicleConverter;
    @Override
    public List<Vehicle> getVehicles() {
        return this.vehicleJpaRepository.findAll();
    }

    @Override
    public VehicleDto getVehicleById(Long id)  {
        Vehicle vehicleById = this.vehicleJpaRepository.findVehicleById(id);
        if(vehicleById==null) return null;
        return this.vehicleConverter.entityToDto(vehicleById);
    }

    @Override
    public VehicleDto addVehicle(VehicleDto vehicleDto) {
       Vehicle vehicle = vehicleConverter.dtoToEntity(vehicleDto);
       return vehicleConverter.entityToDto((Vehicle) vehicleJpaRepository.save(vehicle));
    }
}
