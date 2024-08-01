package com.apirest.autorentax.models.dao;

import com.apirest.autorentax.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User, Long> {
}
