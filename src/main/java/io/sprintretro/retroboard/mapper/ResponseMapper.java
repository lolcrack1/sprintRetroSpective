package io.sprintretro.retroboard.mapper;

import io.sprintretro.retroboard.dto.CreateResponseDTO;
import io.sprintretro.retroboard.dto.ResponseDTO;
import io.sprintretro.retroboard.dto.UpdateResponseDTO;
import io.sprintretro.retroboard.entities.ResponseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ResponseMapper {
    ResponseMapper INSTANCE = Mappers.getMapper(ResponseMapper.class);

    @Mapping(target = "userId", source = "user.id")
    ResponseDTO mapEntityTODto(ResponseEntity responseEntity);

    //ResponseEntity mapDtoToEntity(ResponseDTO responseDto);

    //CreateResponseDTO mapCreateEntityToDto(ResponseEntity responseEntity);

    @Mapping(target = "user.id", source = "userId")
        //@Mapping(target = "swimLane.id", source = "swimLaneId")
    ResponseEntity mapCreateDtoToEntity(CreateResponseDTO createResponseDTO);

    //UpdateResponseDTO mapUpdateEntityToDto(ResponseEntity responseEntity);

    //ResponseEntity mapUpdateDtoToEntity(UpdateResponseDTO updateResponseDTO, @MappingTarget Optional<ResponseEntity> responseEntity);
    ResponseEntity mapUpdateDtoToEntity(UpdateResponseDTO updateResponseDTO, @MappingTarget ResponseEntity responseEntity);

}
