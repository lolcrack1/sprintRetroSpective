package io.sprintretro.retroboard.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id", nullable = false)
    private String emailId;

    @Column(name = "company_name", nullable = true)
    private String companyName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private Set<BoardEntity> boards = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private Set<ResponseEntity> response = new HashSet<>();



    /*public void addBoard(BoardEntity board) {
        this.boards.add(board);
        board.setUser(this);
    }

    public void addResponse(ResponseEntity response) {
        this.response.add(response);
        response.setUser(this);
    }

     */


}
