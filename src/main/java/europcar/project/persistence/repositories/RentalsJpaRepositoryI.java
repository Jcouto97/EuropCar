package europcar.project.persistence.repositories;

import europcar.project.persistence.models.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalsJpaRepositoryI extends JpaRepository<Rental, Long> {
}
