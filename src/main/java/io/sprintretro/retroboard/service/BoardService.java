package io.sprintretro.retroboard.service;

import io.sprintretro.retroboard.dto.BoardDTO;
import io.sprintretro.retroboard.dto.CreateBoardDTO;
import io.sprintretro.retroboard.dto.UpdateBoardDTO;
import io.sprintretro.retroboard.entities.BoardEntity;

import java.util.Optional;

public interface BoardService {

    public BoardDTO boardCreate(CreateBoardDTO createBoardDto);

    public BoardDTO boardUpdate(UpdateBoardDTO updateBoardDto, Long boardId);

    public void boardDelete(Long id);

    public BoardEntity getById(Long boardId);
    //public Optional<BoardEntity> getById(Long boardId);

    public BoardDTO boardRead(Long id);


}
