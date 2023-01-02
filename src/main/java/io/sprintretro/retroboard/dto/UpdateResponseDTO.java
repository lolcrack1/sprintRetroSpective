package io.sprintretro.retroboard.dto;

import io.sprintretro.retroboard.entities.SwimLaneEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UpdateResponseDTO {

    //private Long id;

    //private SwimLaneEntity swimLaneEntity;

    //private UserDTO userDto;
    private String comment;

    private Integer like;
}
