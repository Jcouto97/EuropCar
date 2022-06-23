package europcar.project.persistence.repositories;

import europcar.project.persistence.models.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;
public interface VehicleJpaRepositoryI extends JpaRepositoryI <Vehicle, Long> {

    Vehicle findVehicleById(Long id);
}
