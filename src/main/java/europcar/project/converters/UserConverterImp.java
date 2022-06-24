package europcar.project.converters;

import europcar.project.command.UserDto;
import europcar.project.command.UserUpdateDto;
import europcar.project.persistence.models.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;

@AllArgsConstructor
public class UserConverterImp implements DtoConvertersI<User, UserDto, UserUpdateDto>{

    private final ModelMapper MODEL_MAPPER;


    @Override
    public UserDto entityToDto(User user) {
        return MODEL_MAPPER.map(user, UserDto.class);
    } //convert de instancia para classe

    @Override
    public User dtoToEntity(UserDto userDto) {
        return MODEL_MAPPER.map(userDto, User.class);
    }

    @Override
    public UserUpdateDto entityToUpdateDto(User user) {
        return MODEL_MAPPER.map(user, UserUpdateDto.class);
    }

    @Override
    public User updateDtoToEntity(UserUpdateDto userUpdateDto, User user) {
        this.MODEL_MAPPER.getConfiguration().setSkipNullEnabled(true);
        MODEL_MAPPER.map(userUpdateDto, user);
        return user;
    }

    @Override
    public List<UserDto> convertEntityListToDtoList(List<User> users) {
        return users.stream()
                .map(this::entityToDto) //????
                .toList();
    }

    @Override
    public List<User> convertDtoListToEntityList(List<UserDto> userDtos) {
        return null;
    }
}
