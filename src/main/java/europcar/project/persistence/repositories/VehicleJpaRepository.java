package europcar.project.persistence.repositories;

import europcar.project.persistence.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleJpaRepository extends JpaRepository<Vehicle, Long> {



}
