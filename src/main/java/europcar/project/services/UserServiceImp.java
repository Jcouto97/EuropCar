package europcar.project.services;

import europcar.project.command.RentalDto;
import europcar.project.command.UserDto;
import europcar.project.command.UserUpdateDto;
import europcar.project.converters.UserConverterImp;
import europcar.project.exceptions.RentingException;
import europcar.project.exceptions.UserNotFoundException;
import europcar.project.persistence.models.User;
import europcar.project.persistence.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static europcar.project.exceptions.ExceptionMessages.ExceptionMessages.*;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserServiceI, UserDetailsService {
    private UserRepository userRepository;
    private UserConverterImp userConverterImp;
    private ModelMapper modelMapper;
    //Para converter os Rentals de cada user, visto que o converter desta classe apenas serve para Users
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDto> getUsers() {
        return this.userConverterImp.entityListToDtoList(this.userRepository.findAll());
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND)); //n da?
        return userConverterImp.entityToDto(user);
    }

    @Override
    public List<UserDto> getUserByName(String userName) { //qd + que 1 com nome igual parte
        List<User> users = this.userRepository.findByName(userName);
        if (users.isEmpty()) throw new UserNotFoundException(USER_NAME_NOT_FOUND);
        return users.stream().map(user -> userConverterImp.entityToDto(user)).toList();
    }

    @Override
    public UserDto signUp(UserDto userDto) {
        User userToSave = userConverterImp.dtoToEntity(userDto);
        userToSave.setPassword(passwordEncoder.encode(userToSave.getPassword()));
        this.userRepository.save(userToSave);
        return userConverterImp.entityToDto(userToSave);
    }

    @Override
    public void deleteUser(Long userId) {
        User userToDelete = this.userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));

        if (userToDelete.isRenting()) throw new RentingException(USER_RENTING);
        this.userRepository.delete(userToDelete);
    }

    @Override
    public UserDto updateUser(Long id, UserUpdateDto userUpdateDto) {
        User originalUser = this.userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));
        User updated = userConverterImp.updateDtoToEntity(userUpdateDto, originalUser);
        updated.setPassword(passwordEncoder.encode(updated.getPassword()));
        this.userRepository.save(updated);
        return userConverterImp.entityToDto(updated);
    }

    @Override
    public List<RentalDto> getRents(Long id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(USER_NAME_NOT_FOUND))
                .getRentals().stream()
                .map(rent -> this.modelMapper.map(rent, RentalDto.class))
                .toList();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("Username %s not found", email))
                );
    }
}
