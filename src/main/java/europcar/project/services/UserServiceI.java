package europcar.project.services;

import europcar.project.command.UserDto;

import java.util.List;

public interface UserServiceI {
    List<UserDto> getUsers();
}
