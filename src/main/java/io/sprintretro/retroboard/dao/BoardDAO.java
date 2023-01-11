package io.sprintretro.retroboard.dao;

import io.sprintretro.retroboard.entities.BoardEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardDAO extends CrudRepository<BoardEntity, Long> {


}
