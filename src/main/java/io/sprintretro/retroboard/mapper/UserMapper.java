package io.sprintretro.retroboard.mapper;

import io.sprintretro.retroboard.dto.UserDTO;
import io.sprintretro.retroboard.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);

    //UserDTO mapEntityTODto(UserEntity userEntity);

    //UserEntity mapDtoToEntity(UserDTO userDto);
}
