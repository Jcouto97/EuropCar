package europcar.project.services;

import europcar.project.command.VehicleDto;
import europcar.project.command.VehicleUpdateDto;
import europcar.project.persistence.models.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleServiceI {

    List<VehicleDto> getVehicles();

    VehicleDto getVehicleById(Long id);

    List<VehicleDto> getVehicleByBrand(Long brandId);

    VehicleDto addVehicle(VehicleDto vehicleDto);

    void deleteVehicle(Long id);

    VehicleDto updateVehicle(Long id, VehicleUpdateDto vehicleUpdateDto);
}
