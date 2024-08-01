package com.apirest.autorentax.services;

import com.apirest.autorentax.models.dao.IVehicleDao;
import com.apirest.autorentax.models.entity.Vehicle;
import com.apirest.autorentax.models.entity.view.VVehicle;
import com.apirest.autorentax.services.interfaces.IVehicleService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class VehicleService implements IVehicleService {

    @Autowired
    private IVehicleDao vehicleDao;
    @Autowired
    @Qualifier("entityManagerFactory")
    EntityManager em;

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleDao.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleDao.findAll();
    }

    @Override
    public Vehicle getById(Long id) {
        Optional<Vehicle> vehicle = vehicleDao.findById(id);
        if (vehicle.isPresent()) {
            return vehicle.get();
        } else {
            throw new RuntimeException("Vehicle not found with id: " + id);
        }
    }

    @Override
    public Vehicle updateVehicle(Long id, Vehicle vehicleDetails) throws Exception {
        Vehicle vehicle = vehicleDao.findById(id)
                .orElseThrow(() -> new Exception("Vehicle not found for this id: " + id));

        vehicle.setModel(vehicleDetails.getModel());
        vehicle.setYear(vehicleDetails.getYear());
        vehicle.setManufacturer(vehicleDetails.getManufacturer());
        vehicle.setType(vehicleDetails.getType());
        vehicle.setDescription(vehicleDetails.getDescription());
        vehicle.setPrice(vehicleDetails.getPrice());
        vehicle.setAvailable(vehicleDetails.getAvailable());
        vehicle.setTotal(vehicleDetails.getTotal());

        return vehicleDao.save(vehicle);
    }

    @Override
    public void deleteVehicle(Long id) throws Exception {
        Vehicle vehicle = vehicleDao.findById(id)
                .orElseThrow(() -> new Exception("Vehicle not found for this id: " + id));
        vehicleDao.delete(vehicle);
    }

    @Override
    @Transactional(readOnly = false)
    public List<VVehicle> getViewVehicles(Long id, Long model, String year, Long manufacturer, Long type){
        StoredProcedureQuery findByProcedure = em.createNamedStoredProcedureQuery("fgetvehicles");
        findByProcedure.registerStoredProcedureParameter("p_id", Long.class, ParameterMode.IN);
        findByProcedure.registerStoredProcedureParameter("p_model", Long.class, ParameterMode.IN);
        findByProcedure.registerStoredProcedureParameter("p_year", String.class, ParameterMode.IN);
        findByProcedure.registerStoredProcedureParameter("p_manufacturer", Long.class, ParameterMode.IN);
        findByProcedure.registerStoredProcedureParameter("p_type", Long.class, ParameterMode.IN);

        findByProcedure.setParameter("p_id", id);
        findByProcedure.setParameter("p_model", model);
        findByProcedure.setParameter("p_year", year);
        findByProcedure.setParameter("p_manufacturer", manufacturer);
        findByProcedure.setParameter("p_type", type);

        findByProcedure.execute();
        return (List<VVehicle>) findByProcedure.getResultList();
    }

}
