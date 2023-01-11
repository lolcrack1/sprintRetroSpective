package io.sprintretro.retroboard.service.impl;

import io.sprintretro.retroboard.dao.UserDAO;
import io.sprintretro.retroboard.entities.UserEntity;
import io.sprintretro.retroboard.exception.NoResourceException;
import io.sprintretro.retroboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;


    @Override
    public UserEntity getById(Long id) {
        return userDAO.findById(id).orElseThrow(() -> new NoResourceException("User", "Id", id));

    }
}
