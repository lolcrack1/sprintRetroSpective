package io.sprintretro.retroboard.mapper;

import io.sprintretro.retroboard.dto.CreateResponseDTO;
import io.sprintretro.retroboard.dto.ResponseDTO;
import io.sprintretro.retroboard.dto.UpdateResponseDTO;
import io.sprintretro.retroboard.entities.ResponseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper
public interface ResponseMapper {
    ResponseMapper INSTANCE= Mappers.getMapper(ResponseMapper.class);

    ResponseDTO mapEntityTODto(ResponseEntity responseEntity);

    //ResponseEntity mapDtoToEntity(ResponseDTO responseDto);

    //CreateResponseDTO mapCreateEntityToDto(ResponseEntity responseEntity);

    ResponseEntity mapCreateDtoToEntity(CreateResponseDTO createResponseDTO);

    //UpdateResponseDTO mapUpdateEntityToDto(ResponseEntity responseEntity);

    //ResponseEntity mapUpdateDtoToEntity(UpdateResponseDTO updateResponseDTO, @MappingTarget Optional<ResponseEntity> responseEntity);
    ResponseEntity mapUpdateDtoToEntity(UpdateResponseDTO updateResponseDTO, @MappingTarget ResponseEntity responseEntity);

}
