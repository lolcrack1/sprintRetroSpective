package io.sprintretro.retroboard.dto;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class BoardDTO {

    private Long id;

    private String boardName;

    private Set<SwimLaneDTO> swimlaneDto=new HashSet<>();

    private UserDTO usersDto;
}
