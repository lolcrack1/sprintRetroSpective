package io.sprintretro.retroboard.dao;

import io.sprintretro.retroboard.entities.SwimLaneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwimLaneDAO extends JpaRepository<SwimLaneEntity,Long> {
}
