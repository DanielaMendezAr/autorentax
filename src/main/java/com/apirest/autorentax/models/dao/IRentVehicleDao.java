package com.apirest.autorentax.models.dao;

import com.apirest.autorentax.models.entity.RentVehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentVehicleDao extends JpaRepository <RentVehicle, Long> {
}
