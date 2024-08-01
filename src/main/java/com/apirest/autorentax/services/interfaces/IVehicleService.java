package com.apirest.autorentax.services.interfaces;

import com.apirest.autorentax.models.entity.Vehicle;
import com.apirest.autorentax.models.entity.view.VVehicle;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IVehicleService {
    public Vehicle createVehicle(Vehicle vehicle);

    List<Vehicle> getAllVehicles();

    Vehicle getById(Long id);

    Vehicle updateVehicle(Long id, Vehicle vehicleDetails) throws Exception;

    void deleteVehicle(Long id) throws Exception;

    @Transactional(readOnly = true)
    List<VVehicle> getViewVehicles(Long id, Long model, String Year, Long manufacturer, Long type);
}
