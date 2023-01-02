package io.sprintretro.retroboard.dto;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class UserDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String emailId;

    private String companyName;

    private Set<BoardDTO> boardsDto=new HashSet<>();

    private Set<ResponseDTO> responsesDto=new HashSet<>();
}
