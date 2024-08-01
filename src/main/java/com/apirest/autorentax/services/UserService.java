package com.apirest.autorentax.services;

import com.apirest.autorentax.models.dao.IUserDao;
import com.apirest.autorentax.models.entity.User;
import com.apirest.autorentax.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User createUser(User user) {
        return userDao.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User getById(Long id) {
        Optional<User> user = userDao.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    @Override
    public User updateUser(Long id, User userDetails) throws Exception {
        User user = userDao.findById(id)
                .orElseThrow(() -> new Exception("User not found for this id: " + id));

        user.setName(userDetails.getName());
        user.setLastname(userDetails.getLastname());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setRol(userDetails.getRol());

        return userDao.save(user);
    }

    @Override
    public void deleteUser(Long id) throws Exception {
        User user = userDao.findById(id)
                .orElseThrow(() -> new Exception("User not found for this id: " + id));
        userDao.delete(user);
    }
}
