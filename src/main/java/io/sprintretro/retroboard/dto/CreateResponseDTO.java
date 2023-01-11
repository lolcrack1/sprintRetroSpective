package io.sprintretro.retroboard.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateResponseDTO {

    //private Long swimLaneId;

    //private SwimLaneEntity swimLaneEntity;

    //private UserDTO userDto;

    @NotNull(message = "Response should be belong to user")
    private Long userId;


    private String comments;

    private Integer likes;

    //@NotNull
    //private Long swimLaneId;
}
