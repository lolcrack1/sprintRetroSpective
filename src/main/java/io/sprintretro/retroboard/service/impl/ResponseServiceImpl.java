package io.sprintretro.retroboard.service.impl;

import io.sprintretro.retroboard.dao.BoardDAO;
import io.sprintretro.retroboard.dao.ResponseDAO;
import io.sprintretro.retroboard.dao.SwimLaneDAO;
import io.sprintretro.retroboard.dto.CreateResponseDTO;
import io.sprintretro.retroboard.dto.ResponseDTO;
import io.sprintretro.retroboard.dto.UpdateResponseDTO;
import io.sprintretro.retroboard.entities.ResponseEntity;
import io.sprintretro.retroboard.entities.SwimLaneEntity;
import io.sprintretro.retroboard.entities.UserEntity;
import io.sprintretro.retroboard.exception.NoResourceException;
import io.sprintretro.retroboard.mapper.ResponseMapper;
import io.sprintretro.retroboard.service.ResponseService;
import io.sprintretro.retroboard.service.SwimLaneService;
import io.sprintretro.retroboard.service.UserService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@NoArgsConstructor
public class ResponseServiceImpl implements ResponseService {

    @Autowired
    BoardDAO boardDAO;
    @Autowired
    SwimLaneService swimLaneService;
    @Autowired
    SwimLaneDAO swimLaneDAO;
    private ResponseDAO responseDAO;
    private ResponseMapper responseMapper;
    private UserService userService;

    @Autowired
    public ResponseServiceImpl(ResponseDAO responseDAO, ResponseMapper responseMapper, UserService userService) {
        this.responseDAO = responseDAO;
        this.responseMapper = responseMapper;
        this.userService = userService;
    }

    @Override
    public ResponseDTO responseAdd(CreateResponseDTO createResponseDTO, Long boardId, Long swimLaneId) {
        //BoardEntity board;
        //SwimLaneEntity swimLane;
        //Long bId= board.setId(boardId);
        //Long sId=swimLane.setId(swimLaneId);
        //Boolean exists=boardDAO.existsById(bId);
        //Boolean present=swimLaneDAO.existsById(sId);
        if (boardDAO.existsById(boardId) && swimLaneDAO.existsById(swimLaneId)) {
            ResponseEntity response = responseMapper.mapCreateDtoToEntity(createResponseDTO);
            //userService.getById(createResponseDTO.getUserId().addResponse(ResponseEntity));
            UserEntity user = userService.getById(createResponseDTO.getUserId());
            response.setUser(user);
            SwimLaneEntity swimLane = swimLaneService.getById(swimLaneId);
            response.setSwimLane(swimLane);
            return responseMapper.mapEntityTODto(responseDAO.save(response));
        } else if (!boardDAO.existsById(boardId)) {
            throw new NoResourceException("Board", "Id", boardId);
        } else {
            throw new NoResourceException("SwimLane", "Id", swimLaneId);
        }

    }

    @Override
    public ResponseDTO responseUpdate(Long boardId, Long swimLaneId, Long id, UpdateResponseDTO updateResponseDTO) {
        //ResponseEntity response = getById(id);
        ResponseEntity response=new ResponseEntity();
        if (validateResponse(boardId,swimLaneId,id)){
            response=getById(id);
        }
        //ResponseEntity response = getById(id);
        return responseMapper.mapEntityTODto(responseDAO.save(responseMapper.mapUpdateDtoToEntity(updateResponseDTO, response)));

    }

    @Override
    public void responseDelete(Long boardId, Long swimLaneId, Long id) {
        if(validateResponse(boardId,swimLaneId,id)){
            if (getById(id) != null) {
                responseDAO.deleteById(id);
            }
        }
    }


    @Override
    public ResponseEntity getById(Long id) {
        return responseDAO.findById(id).orElseThrow(() ->
                new NoResourceException("Response", "Id", id));
    }

    @Override
    public ResponseDTO getResponse(Long boardId, Long swimLaneId, Long id) {
        ResponseEntity response = new ResponseEntity();
        if (validateResponse(boardId, swimLaneId, id)) {
            response = getById(id);
        }
        return responseMapper.mapEntityTODto(response);
    }

    @Override
    public Boolean validateResponse(Long boardId, Long swimLaneId, Long responseId) {

        boolean validate = false;
        if (swimLaneService.validateSwimLane(boardId, swimLaneId)) {
            SwimLaneEntity swimLane = swimLaneService.getById(swimLaneId);
            Set<ResponseEntity> responseEntities = swimLane.getResponseSet();
            for (ResponseEntity response : responseEntities) {
                if (response.getId().equals(responseId)) {
                    validate = true;
                    break;
                }
            }
        }
        if (!validate) {
            throw new NoResourceException("Response", "Id", responseId);
        }
        return true;
    }


}
