package io.sprintretro.retroboard.dto;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class BoardDTO {

    private Long id;

    private String boardName;

    private Set<SwimLaneDTO> swimLaneDTOSet = new HashSet<>();

    //private UserDTO usersDto;

    private Long userId;
}
