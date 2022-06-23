package europcar.project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaRepositoryI<S, T> extends JpaRepository <S, T> {



}
