package io.sprintretro.retroboard.controllers;

import io.sprintretro.retroboard.dto.CreateSwimLaneDTO;
import io.sprintretro.retroboard.dto.SwimLaneDTO;
import io.sprintretro.retroboard.dto.UpdateSwimLaneDTO;
import io.sprintretro.retroboard.service.impl.SwimLaneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/boards/")
public class SwimLaneController {

    @Autowired
    private SwimLaneServiceImpl swimLaneService;

    @PostMapping("{boardId}/swimlane/createSwimlane")
    public SwimLaneDTO createSwimLane(@RequestBody CreateSwimLaneDTO createSwimLaneDTO, @PathVariable Long boardId) {

        return swimLaneService.swimLaneCreate(createSwimLaneDTO, boardId);
    }

    @DeleteMapping("{boardId}/swimlane/{id}")
    public void deleteSwimLane(@PathVariable Long boardId, @PathVariable Long id) {

        swimLaneService.swimLaneDelete(boardId, id);
    }

    @GetMapping("{boardId}/swimlane/{id}")
    public SwimLaneDTO getSwimLane(@PathVariable Long boardId, @PathVariable Long id) {
        return swimLaneService.getSwimLane(boardId, id);
    }


    @PutMapping("{boardId}/swimlane/{id}")
    public SwimLaneDTO updateSwimLane(@PathVariable Long boardId, @PathVariable Long id, UpdateSwimLaneDTO updateSwimLaneDTO) {
        return swimLaneService.swimLaneUpdate(boardId, id, updateSwimLaneDTO);

    }

}
