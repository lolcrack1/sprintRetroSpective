package io.sprintretro.retroboard.dao;

import io.sprintretro.retroboard.entities.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardDAO extends JpaRepository<BoardEntity,Long>{

}
