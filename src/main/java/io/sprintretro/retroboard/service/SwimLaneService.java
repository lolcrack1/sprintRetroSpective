package io.sprintretro.retroboard.service;

import io.sprintretro.retroboard.dto.CreateSwimLaneDTO;
import io.sprintretro.retroboard.dto.SwimLaneDTO;
import io.sprintretro.retroboard.dto.UpdateSwimLaneDTO;
import io.sprintretro.retroboard.entities.SwimLaneEntity;

public interface SwimLaneService {


    public SwimLaneDTO swimLaneCreate(CreateSwimLaneDTO createSwimLaneDTO, Long boardId);

    public SwimLaneDTO swimLaneUpdate(Long boardId, Long id, UpdateSwimLaneDTO updateSwimLaneDTO);

    public void swimLaneDelete(Long boardId, Long id);

    public SwimLaneEntity getById(Long swimLaneId);

    public SwimLaneDTO getSwimLane(Long boardId, Long id);

    Boolean validateSwimLane(Long boardId, Long swimLaneId);
}
