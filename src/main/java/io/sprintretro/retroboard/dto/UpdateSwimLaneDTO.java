package io.sprintretro.retroboard.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UpdateSwimLaneDTO {

    @NotBlank(message = "SwimLane name is required")
    private String swimlaneName;

}
