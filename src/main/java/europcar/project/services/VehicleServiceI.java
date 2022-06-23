package europcar.project.services;

import europcar.project.command.VehicleDto;
import europcar.project.persistence.models.Vehicle;

import java.util.List;

public interface VehicleServiceI {
    
    List<Vehicle> getVehicles();

    VehicleDto getVehicleById(Long id);
}
