package europcar.project.persistence.repositories;

import europcar.project.persistence.models.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalsJpaRepositoryI extends JpaRepository<Rental, Long> {
    //@Query("FROM rentals WHERE userIdFk = ?1")
    List<Rental> findByUser(Long id);
}
