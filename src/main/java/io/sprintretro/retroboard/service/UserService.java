package io.sprintretro.retroboard.service;

import io.sprintretro.retroboard.entities.UserEntity;

public interface UserService {

    public UserEntity getById(Long id);
}
