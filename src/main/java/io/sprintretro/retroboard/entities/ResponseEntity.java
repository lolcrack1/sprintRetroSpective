package io.sprintretro.retroboard.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;


@Table(name = "response")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    @ManyToOne
    @JoinColumn(name = "ref_swimlane", nullable = false)
    private SwimLaneEntity swimLane;

    @ManyToOne
    @JoinColumn(name = "ref_user", nullable = false)
    private UserEntity user;

    private String comments;
    private Integer likes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseEntity that = (ResponseEntity) o;
        return id.equals(that.id) && comments.equals(that.comments) && likes.equals(that.likes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comments, likes);
    }


}
