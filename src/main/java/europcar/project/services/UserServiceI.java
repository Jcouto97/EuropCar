package europcar.project.services;

import europcar.project.command.UserDto;
import europcar.project.command.UserUpdateDto;
import europcar.project.persistence.models.User;
import europcar.project.persistence.repositories.Populate;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserServiceI {
    List<UserDto> getUsers();

    UserDto signUp(UserDto userDto);

    UserDto deleteUser(Long userId);

    UserDto updateUser(Long id, UserUpdateDto userUpdateDto);

    UserDto getUserById(Long userId);

    List<UserDto> getUserByName(String userName);

    List<UserDto> signUpAll(Populate<UserDto> usersList);
}
