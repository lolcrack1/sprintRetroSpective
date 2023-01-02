package io.sprintretro.retroboard.entities;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "board")
@Getter
@Setter
public class BoardEntity {

    @Id
    Long id;

    @Column(name="board_name")
    String boardName;

    @OneToMany(fetch= FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "board")
            private Set<SwimLaneEntity> swimlane=new HashSet<>();


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name= "user_id",nullable = false)
    private UserEntity user;
}
