package io.sprintretro.retroboard.controllers;

import io.sprintretro.retroboard.dto.*;
import io.sprintretro.retroboard.service.impl.ResponseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/board/{boardId}/swimlane/{swimlaneId}/response/")
@RestController
public class ResponseController {

    @Autowired
    private ResponseServiceImpl responseService;

    @PostMapping("addResponse")
    public ResponseDTO addResponse(@RequestBody CreateResponseDTO createResponseDTO){

        return responseService.responseAdd(createResponseDTO);
    }

    @DeleteMapping("{id}")
    public void deleteResponse(@PathVariable Long id){

        responseService.responseDelete(id);
    }


    @PutMapping("{id}")
    public ResponseDTO updateResponse(@PathVariable Long id, UpdateResponseDTO updateResponseDTO){
        return responseService.responseUpdate(id,updateResponseDTO);

    }
}
