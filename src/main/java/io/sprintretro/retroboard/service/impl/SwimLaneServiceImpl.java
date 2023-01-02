package io.sprintretro.retroboard.service.impl;

import io.sprintretro.retroboard.dto.CreateSwimLaneDTO;
import io.sprintretro.retroboard.dto.SwimLaneDTO;
import io.sprintretro.retroboard.dto.UpdateSwimLaneDTO;
import io.sprintretro.retroboard.entities.SwimLaneEntity;
import io.sprintretro.retroboard.exception.NoResourceException;
import io.sprintretro.retroboard.mapper.SwimLaneMapper;
import io.sprintretro.retroboard.dao.SwimLaneDAO;
import io.sprintretro.retroboard.service.SwimLaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SwimLaneServiceImpl implements SwimLaneService {

    @Autowired
    private SwimLaneDAO swimLaneDAO;

    @Autowired
    private SwimLaneMapper swimLaneMapper;

    @Override
    public SwimLaneDTO swimLaneCreate(CreateSwimLaneDTO createSwimLaneDTO) {
        SwimLaneEntity swimLaneEntity=swimLaneMapper.mapCreateDtoToEntity(createSwimLaneDTO);
        return swimLaneMapper.mapEntityToDto(swimLaneDAO.save(swimLaneEntity));
    }

    @Override
    public SwimLaneDTO swimLaneUpdate(Long id, UpdateSwimLaneDTO updateSwimLaneDTO) {
        SwimLaneEntity swimLaneEntity=getById(id);
        return swimLaneMapper.mapEntityToDto(swimLaneDAO.save(swimLaneMapper.mapUpdateDtoToEntity(updateSwimLaneDTO,swimLaneEntity)));

    }

    @Override
    public void swimLaneDelete(Long id) {
        if(getById(id)!=null){
            swimLaneDAO.deleteById(id);
        }

    }

    @Override
    public SwimLaneEntity getById(Long swimLaneId) {
        return swimLaneDAO.findById(swimLaneId).orElseThrow(() ->
                new NoResourceException("SwimLane","ID",swimLaneId));
    }
}
