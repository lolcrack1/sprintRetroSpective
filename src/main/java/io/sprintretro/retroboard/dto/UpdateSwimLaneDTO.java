package io.sprintretro.retroboard.dto;

import io.sprintretro.retroboard.entities.BoardEntity;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Data
public class UpdateSwimLaneDTO {

    @NotBlank(message = "SwimLane name is required")
    private String swimlaneName;

}
