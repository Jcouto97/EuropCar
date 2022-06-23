package europcar.project.services;

import europcar.project.command.UserDto;
import europcar.project.persistence.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImp {
    private UserRepository userRepository;

//    public List<UserDto> getStudents() {
//        return this.studentConverter.entityListToDtoList(this.repository.findAll());
//    }
}
