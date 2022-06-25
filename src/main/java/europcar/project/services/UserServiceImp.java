package europcar.project.services;

import europcar.project.command.UserDto;
import europcar.project.command.UserUpdateDto;
import europcar.project.converters.UserConverterImp;
import europcar.project.exceptions.UserAlreadyExists;
import europcar.project.exceptions.UserNotFoundException;
import europcar.project.persistence.models.User;
import europcar.project.persistence.repositories.Populate;
import europcar.project.persistence.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static europcar.project.exceptions.ExceptionMessages.ExceptionMessages.*;

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
    public UserDto getUserById(Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException(USER_NOT_FOUND)); //n da?
        return userConverterImp.entityToDto(user);
    }

    @Override
    public List<UserDto> getUserByName(String userName) {
        List<User> users = this.userRepository.findByName(userName); //como funciona findbyname se fui eu que defini?

        if(users.isEmpty()){
            throw new UserNotFoundException(USER_NAME_NOT_FOUND);
        }

        return users.stream().map(user -> userConverterImp.entityToDto(user)).toList();
    }

    @Override
    public UserDto signUp(UserDto userDto) {
//        EXCEÇAO PERSONALIZADA N FUNCIONA??
//        Optional<User> user = userRepository.findById(userDto.getId());
//
//        if(user.isPresent()){
//            throw new UserAlreadyExists(USER_ALREADY_EXISTS);
//        }

        User userToSave = userConverterImp.dtoToEntity(userDto);

        this.userRepository.save(userToSave);

        return userConverterImp.entityToDto(userToSave);
    }


    @Override //N FUNCIONA
    public List<UserDto> signUpAll(Populate<UserDto> usersList) {
        List<User> users = this.userConverterImp.convertDtoListToEntityList(usersList.getList()); //para ir buscar atributo de lista a classe populate

        List <User> savedUsers= this.userRepository.saveAll(users);

        return userConverterImp.convertEntityListToDtoList(savedUsers);
    }

    @Override
    public UserDto deleteUser(Long userId) {
        User userToDelete = userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException(USER_NOT_FOUND));
        this.userRepository.deleteById(userId);

        return userConverterImp.entityToDto(userToDelete);
    }

    @Override
    public UserDto updateUser(Long id, UserUpdateDto userUpdateDto) {
        User originalUser = this.userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(USER_NOT_FOUND));

        User updated = userConverterImp.updateDtoToEntity(userUpdateDto, originalUser);

        this.userRepository.save(updated);

        return userConverterImp.entityToDto(updated);
    }
}
