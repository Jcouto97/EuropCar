package europcar.project.persistence.repositories;

import europcar.project.persistence.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("FROM User WHERE name LIKE %?1%")
    List<User> findByName(String name);
}
