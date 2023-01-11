package io.sprintretro.retroboard.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Data
@Entity
@Table(name = "board")
@AllArgsConstructor
@NoArgsConstructor
public class BoardEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    @Column(name = "board_name")
    String boardName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "board")
    private Set<SwimLaneEntity> swimlaneSet = new HashSet<>();


    @ManyToOne
    @JoinColumn(name = "ref_user", nullable = false)
    private UserEntity user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardEntity that = (BoardEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
