package io.sprintretro.retroboard.mapper;

import io.sprintretro.retroboard.dto.BoardDTO;
import io.sprintretro.retroboard.dto.CreateBoardDTO;
import io.sprintretro.retroboard.dto.UpdateBoardDTO;
import io.sprintretro.retroboard.dto.UserDTO;
import io.sprintretro.retroboard.entities.BoardEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface BoardMapper {
   // BoardMapper INSTANCE= Mappers.getMapper(BoardMapper.class);

    BoardDTO mapEntityToDto(BoardEntity boardEntity);

    //BoardEntity mapDtoToEntity(BoardDTO boardDto);

    //CreateBoardDTO mapCreateEntityToDto(BoardEntity boardEntity);

    BoardEntity mapCreateDtoToEntity(CreateBoardDTO createBoardDto);

    //UpdateBoardDTO mapUpdateEntityToDto(BoardEntity boardEntity);

     BoardEntity mapUpdateDtoToEntity(UpdateBoardDTO updateBoardDto, @MappingTarget BoardEntity board);


}
