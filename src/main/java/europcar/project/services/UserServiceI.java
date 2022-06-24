package europcar.project.services;

import europcar.project.command.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserServiceI {
    List<UserDto> getUsers();

    UserDto signUp(UserDto userDto);

    UserDto deleteUser(Long userId);
}
