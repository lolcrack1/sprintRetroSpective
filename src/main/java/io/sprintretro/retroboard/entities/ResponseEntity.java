package io.sprintretro.retroboard.entities;

import lombok.*;

import javax.persistence.*;


@Table(name = "response")
@Data
@Entity
public class ResponseEntity {

    @Id
    Long id;

    @ManyToOne(fetch=FetchType.LAZY,optional = false)
    @JoinColumn(name="swimlane_id",nullable = false)
    private SwimLaneEntity swimLane;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id",nullable = false)
    private UserEntity user;


}
