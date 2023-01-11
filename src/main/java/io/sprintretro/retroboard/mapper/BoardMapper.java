package io.sprintretro.retroboard.mapper;

import io.sprintretro.retroboard.dto.BoardDTO;
import io.sprintretro.retroboard.dto.CreateBoardDTO;
import io.sprintretro.retroboard.dto.UpdateBoardDTO;
import io.sprintretro.retroboard.entities.BoardEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = SwimLaneMapper.class)
public interface BoardMapper {
    // BoardMapper INSTANCE= Mappers.getMapper(BoardMapper.class);

    @Mapping(target = "swimLaneDTOSet", source = "swimlaneSet")
    @Mapping(target = "userId", source = "user.id")
    BoardDTO mapEntityToDto(BoardEntity boardEntity);

    //BoardEntity mapDtoToEntity(BoardDTO boardDto);

    //CreateBoardDTO mapCreateEntityToDto(BoardEntity boardEntity);

    @Mapping(target = "user.id", source = "userId")
    BoardEntity mapCreateDtoToEntity(CreateBoardDTO createBoardDto);

    //UpdateBoardDTO mapUpdateEntityToDto(BoardEntity boardEntity);

    BoardEntity mapUpdateDtoToEntity(UpdateBoardDTO updateBoardDto, @MappingTarget BoardEntity board);


}
