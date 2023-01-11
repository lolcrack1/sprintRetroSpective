package io.sprintretro.retroboard.dao;

import io.sprintretro.retroboard.entities.SwimLaneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SwimLaneDAO extends JpaRepository<SwimLaneEntity, Long> {

}
