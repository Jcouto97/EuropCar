package europcar.project.controllers;


import europcar.project.command.UserDto;
import europcar.project.services.UserServiceI;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/student")
public class UserController {
    private UserServiceI userServiceI;

    @GetMapping
    public List<UserDto> getUsers() {
        return this.userServiceI.getUsers();
    }
}
