package com.apirest.autorentax.services;

import com.apirest.autorentax.models.dao.IClientDao;
import com.apirest.autorentax.models.dao.IRentVehicleDao;
import com.apirest.autorentax.models.dto.RentVehicleDTO;
import com.apirest.autorentax.models.entity.Client;
import com.apirest.autorentax.models.entity.RentVehicle;
import com.apirest.autorentax.models.entity.view.VRentVehicle;
import com.apirest.autorentax.services.interfaces.IRentVehicleService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RentVehicleService implements IRentVehicleService {

    @Autowired
    private IRentVehicleDao rentVehicleDao;

    @Autowired
    private IClientDao clientDao;

    @Autowired
    @Qualifier("entityManagerFactory")
    EntityManager em;

@Override
public RentVehicle createRentVehicle(RentVehicleDTO rentVehicleDTO) {
    Client client = new Client();
    client.setName(rentVehicleDTO.getName_client());
    client.setLastname(rentVehicleDTO.getLastname_client());
    client.setNumber_phone(rentVehicleDTO.getNumber_phone_client());
    client.setEmail(rentVehicleDTO.getEmail_client());

    Client savedClient = clientDao.save(client);

    RentVehicle rentVehicle = new RentVehicle();
    rentVehicle.setClient(savedClient.getId());
    rentVehicle.setVehicle(rentVehicleDTO.getVehicle());
    rentVehicle.setOrder_date(rentVehicleDTO.getOrder_date());
    rentVehicle.setRental_time(rentVehicleDTO.getRental_time());
    rentVehicle.setStatus(rentVehicleDTO.getStatus());
    rentVehicle.setInitial_date(rentVehicleDTO.getInitial_date());
    rentVehicle.setFinal_date(rentVehicleDTO.getFinal_date());

    return rentVehicleDao.save(rentVehicle);
}

    @Override
    public List<RentVehicle> getAllRentVehicles() {
        return rentVehicleDao.findAll();
    }

    @Override
    public RentVehicle getById(Long id) {
        Optional<RentVehicle> rentVehicle = rentVehicleDao.findById(id);
        if (rentVehicle.isPresent()) {
            return rentVehicle.get();
        } else {
            throw new RuntimeException("Rent of vehicle not found with id: " + id);
        }
    }

    @Override
    public RentVehicle updateRentVehicle(Long id, RentVehicle rentVehicleDetails) throws Exception {
        RentVehicle rentVehicle = rentVehicleDao.findById(id)
                .orElseThrow(() -> new Exception("Rent of vehicle not found for this id: " + id));

        rentVehicle.setClient(rentVehicleDetails.getClient());
        rentVehicle.setVehicle(rentVehicleDetails.getVehicle());
        rentVehicle.setOrder_date(rentVehicleDetails.getOrder_date());
        rentVehicle.setRental_time(rentVehicleDetails.getRental_time());
        rentVehicle.setStatus(rentVehicleDetails.getStatus());
        rentVehicle.setInitial_date(rentVehicleDetails.getInitial_date());
        rentVehicle.setFinal_date(rentVehicleDetails.getFinal_date());

        return rentVehicleDao.save(rentVehicle);
    }

    @Override
    public void deleteRentVehicle(Long id) throws Exception {
        RentVehicle rentVehicle = rentVehicleDao.findById(id)
                .orElseThrow(() -> new Exception("Rent of vehicle not found for this id: " + id));
        rentVehicleDao.delete(rentVehicle);
    }

    @Override
    @Transactional(readOnly = false)
    public List<VRentVehicle> getViewRentsVehicles(Long id, Long client, Long model, String year,
                                                   Long manufacturer, Long type){
        StoredProcedureQuery findByProcedure = em.createNamedStoredProcedureQuery("fgetrentsvehicles");
        findByProcedure.registerStoredProcedureParameter("p_id", Long.class, ParameterMode.IN);
        findByProcedure.registerStoredProcedureParameter("p_model", Long.class, ParameterMode.IN);
        findByProcedure.registerStoredProcedureParameter("p_client", Long.class, ParameterMode.IN);
        findByProcedure.registerStoredProcedureParameter("p_year", String.class, ParameterMode.IN);
        findByProcedure.registerStoredProcedureParameter("p_manufacturer", Long.class, ParameterMode.IN);
        findByProcedure.registerStoredProcedureParameter("p_type", Long.class, ParameterMode.IN);

        findByProcedure.setParameter("p_id", id);
        findByProcedure.setParameter("p_model", model);
        findByProcedure.setParameter("p_year", year);
        findByProcedure.setParameter("p_client", client);
        findByProcedure.setParameter("p_manufacturer", manufacturer);
        findByProcedure.setParameter("p_type", type);

        findByProcedure.execute();
        return (List<VRentVehicle>) findByProcedure.getResultList();
    }

}
