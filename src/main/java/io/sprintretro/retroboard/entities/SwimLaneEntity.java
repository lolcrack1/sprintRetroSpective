package io.sprintretro.retroboard.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Table(name = "swimlane")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SwimLaneEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;
    @Column(name = "swimlane_name")
    String swimlaneName;
    @ManyToOne
    @JoinColumn(name = "ref_board", nullable = false)
    private BoardEntity board;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "swimLane")
    private Set<ResponseEntity> responseSet = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SwimLaneEntity that = (SwimLaneEntity) o;
        return id.equals(that.id) && swimlaneName.equals(that.swimlaneName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, swimlaneName);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSwimlaneName() {
        return swimlaneName;
    }

    public void setSwimlaneName(String swimlaneName) {
        this.swimlaneName = swimlaneName;
    }

    public BoardEntity getBoard() {
        return board;
    }

    public void setBoard(BoardEntity board) {
        this.board = board;
    }

    public Set<ResponseEntity> getResponseSet() {
        return responseSet;
    }

    public void setResponseSet(Set<ResponseEntity> responseSet) {
        this.responseSet = responseSet;
    }
}
