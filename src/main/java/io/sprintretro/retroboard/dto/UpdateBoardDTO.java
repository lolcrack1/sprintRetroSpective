package io.sprintretro.retroboard.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UpdateBoardDTO {

    //private Integer id;
    //private Long id;

    @NotBlank(message = "Board name is required")
    private String boardName;

    //private Set<SwimLaneDTO> swimlaneDto=new HashSet<>();

    //private UserDTO usersDto;

}
