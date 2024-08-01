package com.apirest.autorentax.models.dao;

import com.apirest.autorentax.models.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientDao extends JpaRepository <Client, Long> {
}
