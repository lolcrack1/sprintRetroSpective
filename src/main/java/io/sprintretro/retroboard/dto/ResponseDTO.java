package io.sprintretro.retroboard.dto;

import lombok.Data;

@Data
public class ResponseDTO {

    private Long id;

    //private SwimLaneEntity swimLaneEntity;

    //private UserDTO userDto;

    private Long userId;

    private String comments;

    private Integer likes;
}
