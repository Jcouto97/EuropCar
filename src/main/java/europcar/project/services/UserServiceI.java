package europcar.project.services;

import europcar.project.command.RentalDto;
import europcar.project.command.UserDto;
import europcar.project.command.UserUpdateDto;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface UserServiceI {
    List<UserDto> getUsers();

    UserDto signUp(UserDto userDto);

    void deleteUser(Long userId);

    UserDto updateUser(Long id, UserUpdateDto userUpdateDto);

    UserDto getUserById(Long userId);

    List<UserDto> getUserByName(String userName);

    List<RentalDto> getRents(Long id);
}
