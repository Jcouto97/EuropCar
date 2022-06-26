package europcar.project.persistence.repositories;

import europcar.project.persistence.models.Vehicle;
import europcar.project.persistence.models.VehicleAtributes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query("FROM Vehicle WHERE brand = ?1")
    List<Vehicle> findAllByBrand(Brand brand);
}
