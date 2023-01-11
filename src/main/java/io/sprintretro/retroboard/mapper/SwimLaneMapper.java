package io.sprintretro.retroboard.mapper;

import io.sprintretro.retroboard.dto.CreateSwimLaneDTO;
import io.sprintretro.retroboard.dto.SwimLaneDTO;
import io.sprintretro.retroboard.dto.UpdateSwimLaneDTO;
import io.sprintretro.retroboard.entities.SwimLaneEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SwimLaneMapper {
    SwimLaneMapper INSTANCE = Mappers.getMapper(SwimLaneMapper.class);

    @Mapping(target = "responseDTOSet", source = "responseSet")
    SwimLaneDTO mapEntityToDto(SwimLaneEntity swimLaneEntity);

    //SwimLaneEntity mapDtoToEntity(SwimLaneDTO swimLaneDto);

    //CreateSwimLaneDTO mapCreateEntityToDto(SwimLaneEntity swimLaneEntity);

    SwimLaneEntity mapCreateDtoToEntity(CreateSwimLaneDTO createSwimLaneDTO);

    //UpdateSwimLaneDTO mapUpdateEntityToDto(SwimLaneEntity swimLaneEntity);

    SwimLaneEntity mapUpdateDtoToEntity(UpdateSwimLaneDTO updateSwimLaneDTO, @MappingTarget SwimLaneEntity swimLane);


}
