package io.sprintretro.retroboard.service;

import io.sprintretro.retroboard.dto.CreateResponseDTO;
import io.sprintretro.retroboard.dto.ResponseDTO;
import io.sprintretro.retroboard.dto.UpdateResponseDTO;
import io.sprintretro.retroboard.entities.ResponseEntity;

public interface ResponseService {

    public ResponseDTO responseAdd(CreateResponseDTO createResponseDTO, Long boardId, Long swimLaneId);

    public ResponseDTO responseUpdate(Long boardId, Long swimLaneId, Long id, UpdateResponseDTO updateResponseDTO);

    public void responseDelete(Long boardId, Long swimLaneId, Long id);

    public ResponseEntity getById(Long id);

    public ResponseDTO getResponse(Long boardId, Long swimLaneId, Long id);

    Boolean validateResponse(Long boardId, Long swimLaneId, Long responseId);
    //public Optional<ResponseEntity> getById(Long id);
}
