package com.apirest.autorentax.controllers;

import com.apirest.autorentax.Alerta;
import com.apirest.autorentax.models.dto.RentVehicleDTO;
import com.apirest.autorentax.models.entity.RentVehicle;
import com.apirest.autorentax.models.entity.view.VRentVehicle;
import com.apirest.autorentax.models.entity.view.VVehicle;
import com.apirest.autorentax.services.RentVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rent-vehicles")
public class RentVehicleController {

    @Autowired
    private RentVehicleService rentVehicleService;

    @PostMapping("/add")
    public ResponseEntity<?> createRentVehicle(@RequestBody RentVehicleDTO rentVehicleDTO) {
        Map<String, Object> response = new HashMap<>();
        try {
            RentVehicle createdRentVehicle = rentVehicleService.createRentVehicle(rentVehicleDTO);
            return new ResponseEntity<>(createdRentVehicle, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", Alerta.ERROR_AL_LEER_DATOS_DB);
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            response.put("mensaje", Alerta.ERROR_INESPERADO);
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/allRents")
    public ResponseEntity<?> getAllRentVehicles() {
        Map<String, Object> response = new HashMap<>();
        try {
            List<RentVehicle> rentVehicles = rentVehicleService.getAllRentVehicles();
            return new ResponseEntity<>(rentVehicles, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al leer datos de la base de datos.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            response.put("mensaje", "Error inesperado.");
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRentVehicleById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            RentVehicle rentVehicle = rentVehicleService.getById(id);
            return new ResponseEntity<>(rentVehicle, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al leer datos de la base de datos.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            response.put("mensaje", "Error inesperado.");
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateRentVehicle(@PathVariable Long id, @RequestBody RentVehicle rentVehicleDetails) {
        Map<String, Object> response = new HashMap<>();
        try {
            RentVehicle updatedRentVehicle = rentVehicleService.updateRentVehicle(id, rentVehicleDetails);
            return new ResponseEntity<>(updatedRentVehicle, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al leer datos de la base de datos.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            response.put("mensaje", "Error inesperado.");
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRentVehicle(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            rentVehicleService.deleteRentVehicle(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al leer datos de la base de datos.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            response.put("mensaje", "Error inesperado.");
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/viewRents")
    public ResponseEntity<?> getViewRentsVehicles(
            @RequestParam(required=false) Long id,
            @RequestParam(required=false) Long client,
            @RequestParam(required=false) Long model,
            @RequestParam(required=false) String year,
            @RequestParam(required=false) Long manufacturer,
            @RequestParam(required=false) Long type
    ) {
        Map<String, Object> response = new HashMap<>();
        try {
            List<VRentVehicle> rents = rentVehicleService.getViewRentsVehicles(id, client, model, year, manufacturer,
                    type);
            return new ResponseEntity<List<VRentVehicle>>(rents, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch(Exception e) {
            response.put("mensaje", Alerta.ERROR_INESPERADO);
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
