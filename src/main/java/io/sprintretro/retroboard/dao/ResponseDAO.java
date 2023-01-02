package io.sprintretro.retroboard.dao;

import io.sprintretro.retroboard.entities.ResponseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseDAO extends JpaRepository<ResponseEntity,Long> {
}
