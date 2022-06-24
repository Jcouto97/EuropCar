package europcar.project.services;

import europcar.project.command.UserDto;
import europcar.project.command.UserUpdateDto;
import europcar.project.converters.UserConverterImp;
import europcar.project.persistence.models.User;
import europcar.project.persistence.repositories.Populate;
import europcar.project.persistence.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserServiceI{
    private UserRepository userRepository;
    private UserConverterImp userConverterImp;


    @Override
    public List<UserDto> getUsers() {
        return this.userConverterImp.convertEntityListToDtoList(this.userRepository.findAll());
    }

    @Override
    public UserDto signUp(UserDto userDto) {
        User userToSave = userConverterImp.dtoToEntity(userDto);

        this.userRepository.save(userToSave);

        return userConverterImp.entityToDto(userToSave);
    }

    @Override
    public UserDto deleteUser(Long userId) {
        User userToDelete = userRepository.findById(userId).orElse(null);

        this.userRepository.deleteById(userId);

        return userConverterImp.entityToDto(userToDelete);
    }

    @Override
    public UserDto updateUser(Long id, UserUpdateDto userUpdateDto) {
        User originalUser = this.userRepository.findById(id).orElse(null);

        if(originalUser==null){
            return null;
        }

        User updated = userConverterImp.updateDtoToEntity(userUpdateDto, originalUser);

        this.userRepository.save(updated);

        return userConverterImp.entityToDto(updated);
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = this.userRepository.findById(userId).orElse(null);

        if(user==null){
            return null;
        }

        return userConverterImp.entityToDto(user);
    }

    @Override
    public List<UserDto> getUserByName(String userName) {
        List<User> users = this.userRepository.findByName(userName);


        return users.stream().map(user -> userConverterImp.entityToDto(user)).toList();
    }

    @Override
    public List<UserDto> signUpAll(Populate<UserDto> usersList) {
        List<User> users = this.userConverterImp.convertDtoListToEntityList(usersList.getList()); //para ir buscar atributo de lista a classe populate

        List <User> savedUsers= this.userRepository.saveAll(users);

        return userConverterImp.convertEntityListToDtoList(savedUsers);
    }

//    @Override
//    public List<UserDto> signUpAll(List<UserDto> userDtoList) {
//        List<User> usersToSave = userConverterImp.convertDtoListToEntityList(userDtoList);
//
//        List <User> usersSaved = this.userRepository.saveAll(usersToSave);
//
//        return userConverterImp.convertEntityListToDtoList(usersSaved);
//    }
}
