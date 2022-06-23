package europcar.project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JPARepository<U, L extends Number> extends JpaRepository{
}
