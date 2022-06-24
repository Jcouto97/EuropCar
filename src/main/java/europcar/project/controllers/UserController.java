package europcar.project.controllers;


import europcar.project.command.UserDto;
import europcar.project.persistence.models.User;
import europcar.project.services.UserServiceI;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {
    private UserServiceI userServiceI;

    @GetMapping
    public List<UserDto> getUsers() {
        return this.userServiceI.getUsers();
    }

    @PostMapping
    public ResponseEntity<UserDto> signUp(@RequestBody UserDto userDto){
        UserDto responseDto = this.userServiceI.signUp(userDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping(path = "{UserId}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable("UserId") Long userId){
        UserDto userDeleted = this.userServiceI.deleteUser(userId);
        return new ResponseEntity<>(userDeleted, HttpStatus.OK);
    }
}
