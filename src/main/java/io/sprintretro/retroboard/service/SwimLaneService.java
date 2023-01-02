package io.sprintretro.retroboard.service;

import io.sprintretro.retroboard.dto.CreateSwimLaneDTO;
import io.sprintretro.retroboard.dto.SwimLaneDTO;
import io.sprintretro.retroboard.dto.UpdateSwimLaneDTO;
import io.sprintretro.retroboard.entities.BoardEntity;
import io.sprintretro.retroboard.entities.SwimLaneEntity;

public interface SwimLaneService {


    public SwimLaneDTO swimLaneCreate(CreateSwimLaneDTO createSwimLaneDTO);

    public SwimLaneDTO swimLaneUpdate(Long id, UpdateSwimLaneDTO updateSwimLaneDTO);

    public void swimLaneDelete(Long id);

    public SwimLaneEntity getById(Long swimLaneId);
}
