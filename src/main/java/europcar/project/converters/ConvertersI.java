package europcar.project.converters;

import java.util.List;

public interface ConvertersI <Entity, Dto, UpdateDto> {

    Dto entityToDto(Entity entity);

    Entity dtoToEntity(Dto dto);

    UpdateDto entityToUpdateDto(Entity entity);

    Entity updateDtoToEntity(UpdateDto update);

    List<Dto> convertEntityListToDtoList(List<Entity> entityList);

    List<Entity> convertDtoListToEntityList(List<Dto> dtoList);

}