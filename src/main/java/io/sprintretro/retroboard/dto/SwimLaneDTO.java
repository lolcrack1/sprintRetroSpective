package io.sprintretro.retroboard.dto;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class SwimLaneDTO {

    private Long id;

    private String swimlaneName;


    private Set<ResponseDTO> responseDTOSet = new HashSet<>();
}
