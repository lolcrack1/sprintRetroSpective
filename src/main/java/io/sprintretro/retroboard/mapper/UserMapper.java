package io.sprintretro.retroboard.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    //UserDTO mapEntityTODto(UserEntity userEntity);

    //UserEntity mapDtoToEntity(UserDTO userDto);
}
