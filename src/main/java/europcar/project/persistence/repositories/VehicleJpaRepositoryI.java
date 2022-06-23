package europcar.project.persistence.repositories;

import europcar.project.persistence.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleJpaRepositoryI extends JpaRepository<Vehicle, Long> {

}
