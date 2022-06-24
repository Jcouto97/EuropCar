package europcar.project.services;

import europcar.project.command.VehicleDto;
import europcar.project.command.VehicleUpdateDto;
import europcar.project.persistence.models.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleServiceI {

    List<Vehicle> getVehicles();

    VehicleDto getVehicleById(Long id) throws Throwable;

    VehicleDto addVehicle(VehicleDto vehicleDto);

    VehicleDto updateVehicle(Long id, VehicleUpdateDto vehicleUpdateDto);

    //delete
    void deleteVehicle(Long id);

    List <VehicleDto> getVehicleByModel(String model);

    List<VehicleDto> getVehicleByType(String type);
}
