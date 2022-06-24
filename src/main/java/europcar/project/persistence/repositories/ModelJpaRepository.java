package europcar.project.persistence.repositories;

import europcar.project.persistence.models.Model;
import europcar.project.persistence.models.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelJpaRepository extends JpaRepository<Model, Long> {
    //@Query("FROM rentals WHERE userIdFk = ?1")
    List<Model> findByName(String name);

}

