package io.sprintretro.retroboard.dao;

import io.sprintretro.retroboard.entities.ResponseEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponseDAO extends CrudRepository<ResponseEntity, Long> {

    //List<ResponseEntity> findResponseEntityListBy

}
