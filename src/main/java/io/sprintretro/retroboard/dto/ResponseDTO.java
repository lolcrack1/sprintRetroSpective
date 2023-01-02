package io.sprintretro.retroboard.dto;

import io.sprintretro.retroboard.entities.SwimLaneEntity;
import lombok.Data;

@Data
public class ResponseDTO {

    private Long id;

    private SwimLaneEntity swimLaneEntity;

    private UserDTO userDto;

    private String comment;

    private Integer like;
}
