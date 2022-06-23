package europcar.project.services;

import europcar.project.persistence.repositories.JPARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RentalsServiceImp implements RentalServiceI{
    private JPARepository jpaRepository;

    @Override
    public String getString() {
        return jpaRepository.getString();
    }

    @Override
    public String postString(String name) {
        jpaRepository.setString(name);
        return jpaRepository.getString();
    }

}
