package europcar.project.persistence.repositories;

import europcar.project.persistence.models.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalsRepositoryI extends JpaRepository<Rental, Long> {
    @Query("FROM Rental WHERE user.id = ?1")
    List<Rental> findByUserId(Long id);

    @Query("FROM Rental WHERE user.name LIKE %?1%")
    List<Rental> findByUserName(String name);

    @Query("FROM Vehicle WHERE id = ?1")
    List<Rental> findByVehicleId(Long id);
}
