package europcar.project.services;

import europcar.project.command.VehicleDto;
import europcar.project.command.VehicleUpdateDto;
import europcar.project.converters.VehicleConverterImpl;
import europcar.project.exceptions.VehicleNotFoundException;
import europcar.project.persistence.models.Vehicle;

import static europcar.project.exceptions.ExceptionMessages.ExceptionMessages.*;
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
        return this.vehicleConverter.entityToDto(vehicleById);
    }

    @Override
    public VehicleDto getVehicleByModel(String model) {
        return null;
    }

    public VehicleDto addVehicle(VehicleDto vehicleDto) {
       Vehicle vehicle = vehicleConverter.dtoToEntity(vehicleDto);
       return vehicleConverter.entityToDto(vehicleJpaRepository.save(vehicle));
    }

    @Override
    public VehicleDto updateVehicle(Long id, VehicleUpdateDto vehicleUpdateDto) {
       Vehicle vehicle =  vehicleConverter.updateDtoToEntity(vehicleUpdateDto, vehicleJpaRepository.findById(id)
               .orElseThrow(() -> new VehicleNotFoundException(VEHICLE_NOT_FOUND)));
        return vehicleConverter.entityToDto(vehicleJpaRepository.save(vehicle));
    }

    @Override
    public void deleteVehicle(Long id) {
        this.vehicleJpaRepository.delete(vehicleJpaRepository.findById(id)
                .orElseThrow(() -> new VehicleNotFoundException(VEHICLE_NOT_FOUND)));
    }



}
