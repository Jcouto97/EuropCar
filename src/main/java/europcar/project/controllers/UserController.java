package europcar.project.controllers;


import europcar.project.command.UserDto;
import europcar.project.command.UserUpdateDto;
import europcar.project.persistence.models.User;
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
    public ResponseEntity<UserDto> getUserById(@PathVariable("UserId") Long userId){
        UserDto userDeleted = this.userServiceI.getUserById(userId);
        return new ResponseEntity<>(userDeleted, HttpStatus.OK);
    }

    @GetMapping(path = "/byname/{UserName}")
    public List<UserDto> getUserByName(@PathVariable("UserName") String userName){
        return this.userServiceI.getUserByName(userName);
    }

    @PostMapping(path = "/signupall/")
    public ResponseEntity<List<UserDto>> signUpAll(@Valid @RequestBody Populate<UserDto> usersList){
        List<UserDto> responseDtoList = this.userServiceI.signUpAll(usersList);
        return new ResponseEntity<>(responseDtoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> signUp(@Valid @RequestBody UserDto userDto){
        UserDto responseDto = this.userServiceI.signUp(userDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{UserId}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable("UserId") Long userId){
        UserDto userDeleted = this.userServiceI.deleteUser(userId);
        return new ResponseEntity<>(userDeleted, HttpStatus.OK);
    }

    @PutMapping(path = "/{UserID}")
    public ResponseEntity<UserDto> updateStudent(@PathVariable("UserID") Long id, @Valid @RequestBody UserUpdateDto userUpdateDto) {
        UserDto userUpdated = this.userServiceI.updateUser(id, userUpdateDto);
        return new ResponseEntity<>(userUpdated, HttpStatus.OK);
    }
}
