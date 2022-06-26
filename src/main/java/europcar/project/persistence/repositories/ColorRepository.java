package europcar.project.persistence.repositories;

import europcar.project.persistence.models.VehicleAtributes.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Long> {
}
