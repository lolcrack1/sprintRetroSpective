package io.sprintretro.retroboard.dto;

import io.sprintretro.retroboard.entities.BoardEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Data
public class CreateSwimLaneDTO {

    @NotBlank(message = "Swimlane should have name")
    private String swimlaneName;



}
