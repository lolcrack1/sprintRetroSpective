package io.sprintretro.retroboard.service.impl;

import io.sprintretro.retroboard.dto.BoardDTO;
import io.sprintretro.retroboard.dto.CreateBoardDTO;
import io.sprintretro.retroboard.dto.UpdateBoardDTO;
import io.sprintretro.retroboard.entities.BoardEntity;
import io.sprintretro.retroboard.entities.UserEntity;
import io.sprintretro.retroboard.exception.NoResourceException;
import io.sprintretro.retroboard.mapper.BoardMapper;
import io.sprintretro.retroboard.dao.BoardDAO;
import io.sprintretro.retroboard.service.BoardService;
import io.sprintretro.retroboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDAO boardDAO;

    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private UserService userService;
    @Override
    public BoardDTO boardCreate(CreateBoardDTO createBoardDto) {
        //boardRepository.save(new Board());
        //boardDAO.save(boardMapper.mapDtoToEntity(createBoardDto));
        BoardEntity board=boardMapper.mapCreateDtoToEntity(createBoardDto);
        //board.setUsers(userService.getById(createBoardDto.getUserId()));
        UserEntity user=userService.getById(createBoardDto.getUserId());
        user.addBoard(board);
        board =boardDAO.save(board);
        return boardMapper.mapEntityToDto(board);
    }

    @Override
    public BoardDTO boardUpdate(UpdateBoardDTO updateBoardDto, Long boardId) {
        //boardDAO.save(boardMapper.mapDtoToEntity(updateBoardDto));
        BoardEntity board= getById(boardId);
        //BoardEntity board=boardMapper.mapDtoToUpdateEntity(updateBoardDto);
        //board=boardMapper.mapUpdateDtoToEntity(updateBoardDto);
        board=boardDAO.save(boardMapper.mapUpdateDtoToEntity(updateBoardDto,board));
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
        if(getById(boardId)!=null){
            boardDAO.deleteById(boardId);
        }

    }

    @Override
    public BoardEntity getById(Long boardId){
        return  boardDAO.findById(boardId).orElseThrow(() ->
                new NoResourceException("Board","Id",boardId));
    }

    /*
    @Override
    public Optional<BoardEntity> getById(Long boardId){
        return Optional.ofNullable(boardDAO.findById(boardId).orElseThrow(() ->
                new NoResourceException("Board", "Id", boardId)));
    }*/


    @Override
    public BoardDTO boardRead(Long id) {

        //BoardEntity board=getById(id);
        BoardEntity board=getById(id);
        //List<BoardEntity> boardEntity=boardDAO.findAll();
        board= boardDAO.findById(id).orElseThrow(()->new NoResourceException("Board","Id",id));
        return boardMapper.mapEntityToDto(board);
    }
}
