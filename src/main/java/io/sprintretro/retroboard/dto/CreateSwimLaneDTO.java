package io.sprintretro.retroboard.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateSwimLaneDTO {

    @NotBlank(message = "Swimlane should have name")
    private String swimlaneName;


}
