package europcar.project.services;

import europcar.project.command.VehicleDto;
import europcar.project.converters.VehicleConverterImpl;
import europcar.project.persistence.models.Vehicle;


import europcar.project.persistence.repositories.VehicleJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServiceImp implements VehicleServiceI {

    private final VehicleJpaRepository vehicleJpaRepository;
    private final VehicleConverterImpl vehicleConverter;

    public List<Vehicle> getVehicles() {
        return this.vehicleJpaRepository.findAll();
    }


    public VehicleDto getVehicleById(Long id)  {
        Vehicle vehicleById = this.vehicleJpaRepository.findById(id).get();
        if(vehicleById==null) return null;
        return this.vehicleConverter.entityToDto(vehicleById);
    }


    public VehicleDto addVehicle(VehicleDto vehicleDto) {
       Vehicle vehicle = vehicleConverter.dtoToEntity(vehicleDto);
       return vehicleConverter.entityToDto(vehicleJpaRepository.save(vehicle));
    }
}
