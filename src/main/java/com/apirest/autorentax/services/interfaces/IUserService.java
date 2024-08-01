package com.apirest.autorentax.services.interfaces;

import com.apirest.autorentax.models.entity.User;

import java.util.List;

public interface IUserService {
    User createUser(User user);

    List<User> getAllUsers();

    User getById(Long id);

    User updateUser(Long id, User userDetails) throws Exception;

    void deleteUser(Long id) throws Exception;
}
