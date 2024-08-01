package com.apirest.autorentax.models.dao;

import com.apirest.autorentax.models.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehicleDao extends JpaRepository <Vehicle, Long> {
}
