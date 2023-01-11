package io.sprintretro.retroboard.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
public class CreateBoardDTO {


    @NotBlank(message = "Board should have name.")
    private String boardName;

    //private Set<SwimLaneDTO> swimlaneDto=new HashSet<>();

    //private UserDTO usersDto;

    @NotNull(message = "User is required for the creation of board")
    private Long userId;

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
