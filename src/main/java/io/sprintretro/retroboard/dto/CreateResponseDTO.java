package io.sprintretro.retroboard.dto;

import io.sprintretro.retroboard.entities.SwimLaneEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CreateResponseDTO {

    //private Long swimLaneId;

    //private SwimLaneEntity swimLaneEntity;

    //private UserDTO userDto;

    @NotNull(message = "Response should be belong to user")
    private  Long userId;

    @NotBlank
    private String comment;

    @NotNull
    private Integer like;
}
