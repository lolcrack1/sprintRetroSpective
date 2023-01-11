package io.sprintretro.retroboard.service.impl;

import io.sprintretro.retroboard.dao.BoardDAO;
import io.sprintretro.retroboard.dto.BoardDTO;
import io.sprintretro.retroboard.dto.CreateBoardDTO;
import io.sprintretro.retroboard.dto.UpdateBoardDTO;
import io.sprintretro.retroboard.entities.BoardEntity;
import io.sprintretro.retroboard.entities.UserEntity;
import io.sprintretro.retroboard.exception.NoResourceException;
import io.sprintretro.retroboard.mapper.BoardMapper;
import io.sprintretro.retroboard.service.BoardService;
import io.sprintretro.retroboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {


    private BoardDAO boardDAO;


    private BoardMapper boardMapper;


    private UserService userService;


    @Autowired
    public BoardServiceImpl(BoardDAO boardDAO, BoardMapper boardMapper, UserService userService) {
        this.boardDAO = boardDAO;
        this.boardMapper = boardMapper;
        this.userService = userService;
    }

    @Override
    public BoardDTO boardCreate(CreateBoardDTO createBoardDto) {
        //boardRepository.save(new Board());
        //boardDAO.save(boardMapper.mapDtoToEntity(createBoardDto));
        BoardEntity board = boardMapper.mapCreateDtoToEntity(createBoardDto);
        //board.setUsers(userService.getById(createBoardDto.getUserId()));
        UserEntity user = userService.getById(createBoardDto.getUserId());
        // user.addBoard(board);
        board.setUser(user);
        board = boardDAO.save(board);
        return boardMapper.mapEntityToDto(board);
    }

    @Override
    public BoardDTO boardUpdate(UpdateBoardDTO updateBoardDto, Long boardId) {
        //boardDAO.save(boardMapper.mapDtoToEntity(updateBoardDto));
        BoardEntity board = getById(boardId);
        //BoardEntity board=boardMapper.mapDtoToUpdateEntity(updateBoardDto);
        //board=boardMapper.mapUpdateDtoToEntity(updateBoardDto);
        board = boardDAO.save(boardMapper.mapUpdateDtoToEntity(updateBoardDto, board));
        return boardMapper.mapEntityToDto(board);

    }
/*
    @Override
    public BoardDTO boardUpdate(UpdateBoardDTO updateBoardDto, Long boardId) {
        //boardDAO.save(boardMapper.mapDtoToEntity(updateBoardDto));
        Optional<BoardEntity> board= getById(boardId);
        //BoardEntity board=boardMapper.mapDtoToUpdateEntity(updateBoardDto);
        //board=boardMapper.mapUpdateDtoToEntity(updateBoardDto);
        board=boardDAO.save(boardMapper.mapUpdateDtoToEntity(updateBoardDto,board));
        return boardMapper.mapEntityToDto(board);

    }*/


    @Override
    public void boardDelete(Long boardId) {
        if (getById(boardId) != null) {
            boardDAO.deleteById(boardId);
        }
    }

    @Override
    public BoardEntity getById(Long boardId) {
        return boardDAO.findById(boardId).orElseThrow(() ->
                new NoResourceException("Board", "Id", boardId));
    }

    @Override
    public BoardDTO boardRead(Long id) {
        BoardEntity board = getById(id);
        return boardMapper.mapEntityToDto(board);
    }
}
