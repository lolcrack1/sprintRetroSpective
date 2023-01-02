package io.sprintretro.retroboard.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


@Data
public class CreateBoardDTO {


        @NotBlank(message = "Board should have name.")
        private String boardName;

        //private Set<SwimLaneDTO> swimlaneDto=new HashSet<>();

        //private UserDTO usersDto;

        @NotNull(message = "User is required for the creation of board")
        private Long userId;

}
