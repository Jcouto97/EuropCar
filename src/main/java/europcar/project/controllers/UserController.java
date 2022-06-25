package europcar.project.controllers;


import europcar.project.command.RentalDto;
import europcar.project.command.UserDto;
import europcar.project.command.UserUpdateDto;
import europcar.project.persistence.repositories.Populate;
import europcar.project.services.UserServiceI;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping(path = "/byid/{UserId}")
    public UserDto getUserById(@PathVariable("UserId") Long userId){
        return this.userServiceI.getUserById(userId);
    }

    @GetMapping(path = "/byname/{UserName}")
    public List<UserDto> getUserByName(@PathVariable("UserName") String userName){
        return this.userServiceI.getUserByName(userName);
    }

    @PostMapping(path = "/signupall/")
    public List<UserDto> signUpAll(@Valid @RequestBody Populate<UserDto> usersList){
        return this.userServiceI.signUpAll(usersList);
    }

    @PostMapping
    public UserDto signUp(@Valid @RequestBody UserDto userDto){
        return this.userServiceI.signUp(userDto);
    }

    @DeleteMapping(path = "/{UserId}")
    public UserDto deleteUser(@PathVariable("UserId") Long userId){
        return this.userServiceI.deleteUser(userId);
    }

    @PutMapping(path = "/{UserID}")
    public UserDto updateUser(@PathVariable("UserID") Long id, @Valid @RequestBody UserUpdateDto userUpdateDto) {
        return this.userServiceI.updateUser(id, userUpdateDto);
    }

    @GetMapping("/{id}/rents")
    public List<RentalDto> getRents(@PathVariable("id") Long id) {
        return this.userServiceI.getRents(id);
    }
}
