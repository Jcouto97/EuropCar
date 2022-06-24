package europcar.project.services;

import europcar.project.command.UserDto;
import europcar.project.command.UserUpdateDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserServiceI {
    List<UserDto> getUsers();

    UserDto signUp(UserDto userDto);

    UserDto deleteUser(Long userId);

    UserDto updateUser(Long id, UserUpdateDto userUpdateDto);
}
