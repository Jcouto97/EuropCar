package europcar.project.converters;

public interface UpdateDtoConvertersI<Entity, UpdateDto> {
    UpdateDto entityToUpdateDto(Entity entity);

    Entity updateDtoToEntity(UpdateDto updateDto, Entity entity);
}
