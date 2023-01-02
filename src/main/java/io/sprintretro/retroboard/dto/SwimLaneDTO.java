package io.sprintretro.retroboard.dto;

import io.sprintretro.retroboard.entities.BoardEntity;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class SwimLaneDTO {

    private String swimlaneName;

    private BoardEntity boardEntity;

    private Set<ResponseDTO> responseDto = new HashSet<>();
}
