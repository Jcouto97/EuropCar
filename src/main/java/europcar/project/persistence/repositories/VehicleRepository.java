package europcar.project.persistence.repositories;

import europcar.project.persistence.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {


   List <Vehicle> findByModel(String model);

    List<Vehicle> findByType(String type);
}
