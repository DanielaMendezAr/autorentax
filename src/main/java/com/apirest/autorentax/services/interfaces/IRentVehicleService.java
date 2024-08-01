package com.apirest.autorentax.services.interfaces;

import com.apirest.autorentax.models.dto.RentVehicleDTO;
import com.apirest.autorentax.models.entity.RentVehicle;
import com.apirest.autorentax.models.entity.view.VRentVehicle;
import com.apirest.autorentax.models.entity.view.VVehicle;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IRentVehicleService {

    RentVehicle createRentVehicle(RentVehicleDTO rentVehicleDTO);

    List<RentVehicle> getAllRentVehicles();

    RentVehicle getById(Long id);

    RentVehicle updateRentVehicle(Long id, RentVehicle rentVehicleDetails) throws Exception;

    void deleteRentVehicle(Long id) throws Exception;

    @Transactional(readOnly = false)
    List<VRentVehicle> getViewRentsVehicles(Long id, Long client, Long model, String year,
                                            Long manufacturer, Long type);

}
