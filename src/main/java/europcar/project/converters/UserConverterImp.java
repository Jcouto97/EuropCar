package europcar.project.converters;

import europcar.project.command.UserDto;
import europcar.project.command.UserUpdateDto;
import europcar.project.persistence.models.User;
import org.modelmapper.ModelMapper;

import java.util.List;

public class UserConverterImp implements ConvertersI<User, UserDto, UserUpdateDto> {

    private final ModelMapper MODEL_MAPPER;

    public UserConverterImp(ModelMapper modelMapper) {
        this.MODEL_MAPPER = modelMapper;
        this.MODEL_MAPPER.getConfiguration().setSkipNullEnabled(true);
    }

    @Override
    public UserDto entityToDto(User user) {
        return MODEL_MAPPER.map(user, UserDto.class);
    }

    @Override
    public User dtoToEntity(UserDto userDto) {
        return MODEL_MAPPER.map(userDto, User.class);
    }

    @Override
    public UserUpdateDto entityToUpdateDto(User user) {
        return MODEL_MAPPER.map(user, UserUpdateDto.class);
    }

    @Override
    public User updateDtoToEntity(UserUpdateDto update) {
        return MODEL_MAPPER.map(update, User.class);
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
