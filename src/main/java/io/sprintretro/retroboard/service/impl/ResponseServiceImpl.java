package io.sprintretro.retroboard.service.impl;

import io.sprintretro.retroboard.dto.CreateResponseDTO;
import io.sprintretro.retroboard.dto.ResponseDTO;
import io.sprintretro.retroboard.dto.UpdateResponseDTO;
import io.sprintretro.retroboard.entities.ResponseEntity;
import io.sprintretro.retroboard.exception.NoResourceException;
import io.sprintretro.retroboard.mapper.ResponseMapper;
import io.sprintretro.retroboard.dao.ResponseDAO;
import io.sprintretro.retroboard.service.ResponseService;
import io.sprintretro.retroboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResponseServiceImpl implements ResponseService {

    @Autowired
    private ResponseDAO responseDAO;

    @Autowired
    private ResponseMapper responseMapper;

    @Autowired
    private UserService userService;


    @Override
    public ResponseDTO responseAdd(CreateResponseDTO createResponseDTO) {
        ResponseEntity response=responseMapper.mapCreateDtoToEntity(createResponseDTO);
        //userService.getById(createResponseDTO.getUserId().addResponse(ResponseEntity));

        return responseMapper.mapEntityTODto(responseDAO.save(response));

    }

    @Override
    public ResponseDTO responseUpdate(Long id, UpdateResponseDTO updateResponseDTO) {
        //ResponseEntity response = getById(id);
        ResponseEntity response = getById(id);
        return responseMapper.mapEntityTODto(responseDAO.save(responseMapper.mapUpdateDtoToEntity(updateResponseDTO,response)));

    }

    @Override
    public void responseDelete(Long id) {
        if (getById(id)!=null){
            responseDAO.deleteById(id);
        }

    }

   /* @Override
    public Optional<ResponseEntity> getById(Long id) {
        //return Optional.empty();
        return Optional.ofNullable(responseDAO.findById(id).orElseThrow(() ->
                new NoResourceException("Response", "Id", id)));
    }*/

    @Override
    public ResponseEntity getById(Long id) {
        return responseDAO.findById(id).orElseThrow(() ->
                new NoResourceException("Response","Id",id));
    }
}
