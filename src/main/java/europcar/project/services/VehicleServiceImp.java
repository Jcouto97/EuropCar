package europcar.project.services;

import europcar.project.command.VehicleDto;
import europcar.project.converters.VehicleConverterImpl;
import europcar.project.exceptions.VehicleNotFoundException;
import europcar.project.persistence.models.Vehicle;
import europcar.project.persistence.repositories.VehicleJpaRepositoryI;
import lombok.AllArgsConstructor;
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
    public VehicleDto getVehicleById(Long id) {
        Vehicle vehicleById = this.vehicleJpaRepository.findById(id)
                .orElseThrow(()-> {
                    throw new VehicleNotFoundException("Vehicle not found");
                });
        return this.vehicleConverter.entityToDto(vehicleById);
    }
}
