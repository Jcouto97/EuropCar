package europcar.project.persistence.repositories;

import europcar.project.persistence.models.Rentals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalsJpaRepositoryI extends JpaRepository<Rentals, Long> {
}
