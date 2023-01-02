package io.sprintretro.retroboard.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "swimlane")
@Data
@Entity
public class SwimLaneEntity {

    @Id
    Long id;

    @Column(name="swimlane_name")
    String swimlaneName;

    @ManyToOne(fetch =FetchType.LAZY, optional = false)
    @JoinColumn(name= "board_id", nullable = false)
    private BoardEntity board;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "swimLane")
    private Set<ResponseEntity> responses = new HashSet<>();


}
