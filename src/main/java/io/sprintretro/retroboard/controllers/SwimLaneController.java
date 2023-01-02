package io.sprintretro.retroboard.controllers;

import io.sprintretro.retroboard.dto.CreateSwimLaneDTO;
import io.sprintretro.retroboard.dto.SwimLaneDTO;
import io.sprintretro.retroboard.dto.UpdateSwimLaneDTO;
import io.sprintretro.retroboard.service.impl.BoardServiceImpl;
import io.sprintretro.retroboard.service.impl.SwimLaneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/board/{boardId}/swimlane/")
public class SwimLaneController {

    @Autowired
    private SwimLaneServiceImpl swimLaneService;

    @PostMapping("createSwimlane")
    public  SwimLaneDTO createSwimLane(@RequestBody CreateSwimLaneDTO createSwimLaneDTO){

        return swimLaneService.swimLaneCreate(createSwimLaneDTO);
    }

    @DeleteMapping("{id}")
    public void deleteSwimLane(@PathVariable Long id){

        swimLaneService.swimLaneDelete(id);
    }


    @PutMapping("{id}")
    public SwimLaneDTO updateSwimLane(@PathVariable Long id, UpdateSwimLaneDTO updateSwimLaneDTO){
        return swimLaneService.swimLaneUpdate(id,updateSwimLaneDTO);

    }
}
