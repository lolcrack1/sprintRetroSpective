package io.sprintretro.retroboard.service;

import io.sprintretro.retroboard.dto.CreateResponseDTO;
import io.sprintretro.retroboard.dto.ResponseDTO;
import io.sprintretro.retroboard.dto.UpdateResponseDTO;
import io.sprintretro.retroboard.entities.ResponseEntity;

import java.util.Optional;

public interface ResponseService {

    public ResponseDTO responseAdd(CreateResponseDTO createResponseDTO);

    public ResponseDTO responseUpdate(Long id, UpdateResponseDTO updateResponseDTO);

    public void responseDelete(Long id);

    public ResponseEntity getById(Long id);
    //public Optional<ResponseEntity> getById(Long id);
}
