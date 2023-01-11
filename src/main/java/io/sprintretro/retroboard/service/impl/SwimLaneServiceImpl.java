package io.sprintretro.retroboard.service.impl;

import io.sprintretro.retroboard.dao.BoardDAO;
import io.sprintretro.retroboard.dao.SwimLaneDAO;
import io.sprintretro.retroboard.dto.CreateSwimLaneDTO;
import io.sprintretro.retroboard.dto.SwimLaneDTO;
import io.sprintretro.retroboard.dto.UpdateSwimLaneDTO;
import io.sprintretro.retroboard.entities.BoardEntity;
import io.sprintretro.retroboard.entities.SwimLaneEntity;
import io.sprintretro.retroboard.exception.NoResourceException;
import io.sprintretro.retroboard.mapper.SwimLaneMapper;
import io.sprintretro.retroboard.service.BoardService;
import io.sprintretro.retroboard.service.SwimLaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class SwimLaneServiceImpl implements SwimLaneService {

    @Autowired
    private SwimLaneDAO swimLaneDAO;

    @Autowired
    private BoardDAO boardDAO;

    @Autowired
    private SwimLaneMapper swimLaneMapper;

    @Autowired
    private BoardService boardService;

    @Override
    public SwimLaneDTO swimLaneCreate(CreateSwimLaneDTO createSwimLaneDTO, Long boardId) {
        //BoardEntity board;
        //Long id= board.setId(boardId);
        //Boolean exits= boardDAO.existsById(boardId);
        if (boardDAO.existsById(boardId)) {
            SwimLaneEntity swimLane = swimLaneMapper.mapCreateDtoToEntity(createSwimLaneDTO);
            BoardEntity boardEntity = boardService.getById(boardId);
            swimLane.setBoard(boardEntity);
            swimLane = swimLaneDAO.save(swimLane);
            return swimLaneMapper.mapEntityToDto(swimLane);
            //return swimLaneMapper.mapEntityToDto(swimLaneDAO.save(swimLane));
        } else {
            throw new NoResourceException("Board", "Id", boardId);
        }
    }

    @Override
    public SwimLaneDTO swimLaneUpdate(Long boardId, Long id, UpdateSwimLaneDTO updateSwimLaneDTO) {
        SwimLaneEntity swimLane= new SwimLaneEntity();
        if (validateSwimLane(boardId,id)){
            swimLane = getById(id);
        }
        //return swimLaneMapper.mapEntityToDto(swimLaneDAO.save(swimLaneMapper.mapUpdateDtoToEntity(updateSwimLaneDTO, swimLaneEntity)));
        swimLane = swimLaneMapper.mapUpdateDtoToEntity(updateSwimLaneDTO, swimLane);
        swimLane = swimLaneDAO.save(swimLane);
        return swimLaneMapper.mapEntityToDto(swimLane);

    }

    @Override
    public void swimLaneDelete(Long boardId, Long id) {
        if(validateSwimLane(boardId,id)){
            if (getById(id) != null) {
                swimLaneDAO.deleteById(id);
            }
        }
    }

    @Override
    public SwimLaneEntity getById(Long swimLaneId) {
        return swimLaneDAO.findById(swimLaneId).orElseThrow(() ->
                new NoResourceException("SwimLane", "ID", swimLaneId));
    }

    @Override
    public SwimLaneDTO getSwimLane(Long boardId, Long id) {
        SwimLaneEntity swimLane=new SwimLaneEntity();
        if(validateSwimLane(boardId,id)){
            swimLane=getById(id);
        }
        return swimLaneMapper.mapEntityToDto(swimLane);

    }

    @Override
    public Boolean validateSwimLane(Long boardId, Long swimLaneId) {

        boolean validate = false;

        if (boardDAO.existsById(boardId)) {
            BoardEntity board=boardService.getById(boardId);
            Set<SwimLaneEntity> swimLaneEntities = board.getSwimlaneSet();
            for (SwimLaneEntity p : swimLaneEntities) {
                if (p.getId().equals(swimLaneId)){
                    validate = true;
                    break;
                }
            }

        } else {
            throw new NoResourceException("Board", "Id", boardId);
        }
        if(!validate)
            throw new NoResourceException("SwimLane","Id",swimLaneId);
        return true;
    }
}
