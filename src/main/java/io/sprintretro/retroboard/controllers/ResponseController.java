package io.sprintretro.retroboard.controllers;

import io.sprintretro.retroboard.dto.CreateResponseDTO;
import io.sprintretro.retroboard.dto.ResponseDTO;
import io.sprintretro.retroboard.dto.UpdateResponseDTO;
import io.sprintretro.retroboard.service.impl.ResponseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/boards/")
@RestController
public class ResponseController {

    @Autowired
    private ResponseServiceImpl responseService;

    @PostMapping("{boardId}/swimlane/{swimLaneId}/response/addResponse")
    public ResponseDTO addResponse(@RequestBody CreateResponseDTO createResponseDTO, @PathVariable Long boardId, @PathVariable Long swimLaneId) {

        return responseService.responseAdd(createResponseDTO, boardId, swimLaneId);
    }

    @GetMapping("{boardId}/swimlane/{swimLaneId}/response/{id}")
    public ResponseDTO getResponse(@PathVariable Long boardId, @PathVariable Long swimLaneId, @PathVariable Long id) {
        return responseService.getResponse(boardId, swimLaneId, id);
    }

    @DeleteMapping("{boardId}/swimlane/{swimlaneId}/response/{id}")
    public void deleteResponse(@PathVariable Long boardId, @PathVariable Long swimLaneId, @PathVariable Long id) {

        responseService.responseDelete(boardId, swimLaneId, id);
    }


    @PutMapping("{boardId}/swimlane/{swimlaneId}/response/{id}")
    public ResponseDTO updateResponse(@PathVariable Long boardId, @PathVariable Long swimLaneId, @PathVariable Long id, UpdateResponseDTO updateResponseDTO) {
        return responseService.responseUpdate(boardId, swimLaneId, id, updateResponseDTO);

    }
}
