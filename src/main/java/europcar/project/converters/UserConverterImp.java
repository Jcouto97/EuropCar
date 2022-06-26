package europcar.project.converters;

import europcar.project.command.UserDto;
import europcar.project.command.UserUpdateDto;
import europcar.project.persistence.models.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class UserConverterImp implements DtoConvertersI<User, UserDto>, UpdateDtoConverterI<User, UserUpdateDto> {

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
    public List<UserDto> entityListToDtoList(List<User> users) {
        return users.stream()
                .map(this::entityToDto) //????
                .toList();
    }
}
