package europcar.project.persistence.repositories;

import europcar.project.persistence.models.Agency;
import europcar.project.persistence.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long> {
}
