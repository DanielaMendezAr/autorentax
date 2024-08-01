package com.apirest.autorentax.controllers;

import com.apirest.autorentax.Alerta;
import com.apirest.autorentax.models.entity.Vehicle;
import com.apirest.autorentax.models.entity.view.VVehicle;
import com.apirest.autorentax.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/add")
    public ResponseEntity<?> createVehicle(@RequestBody Vehicle vehicle) {
        Map<String, Object> response = new HashMap<>();
        try {
            Vehicle createdVehicle = vehicleService.createVehicle(vehicle);
            return new ResponseEntity<>(createdVehicle, HttpStatus.OK);
        } catch(DataAccessException e) {
            response.put("mensaje", Alerta.ERROR_AL_LEER_DATOS_DB);
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch(Exception e) {
            response.put("mensaje", Alerta.ERROR_INESPERADO);
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/allVehicles")
    public ResponseEntity<?> getAllVehicles() {
        Map<String, Object> response = new HashMap<>();
        try{
            List<Vehicle> vehicles = vehicleService.getAllVehicles();
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        } catch(DataAccessException e) {
            response.put("mensaje", Alerta.ERROR_AL_LEER_DATOS_DB);
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch(Exception e) {
            response.put("mensaje", Alerta.ERROR_INESPERADO);
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVehicleById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Vehicle vehicle = vehicleService.getById(id);
            return new ResponseEntity<>(vehicle, HttpStatus.OK);
        } catch(DataAccessException e) {
            response.put("mensaje", Alerta.ERROR_AL_LEER_DATOS_DB);
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch(Exception e) {
            response.put("mensaje", Alerta.ERROR_INESPERADO);
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicleDetails) {
        Map<String, Object> response = new HashMap<>();
        try {
            Vehicle updatedVehicle = vehicleService.updateVehicle(id, vehicleDetails);
            return new ResponseEntity<>(updatedVehicle, HttpStatus.OK);
        } catch(DataAccessException e) {
            response.put("mensaje", Alerta.ERROR_AL_LEER_DATOS_DB);
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch(Exception e) {
            response.put("mensaje", Alerta.ERROR_INESPERADO);
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            vehicleService.deleteVehicle(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(DataAccessException e) {
            response.put("mensaje", Alerta.ERROR_AL_LEER_DATOS_DB);
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch(Exception e) {
            response.put("mensaje", Alerta.ERROR_INESPERADO);
            response.put("error", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/viewVehicles")
    public ResponseEntity<?> getViewAllVehicles(
            @RequestParam(required=false) Long id,
            @RequestParam(required=false) Long model,
            @RequestParam(required=false) String year,
            @RequestParam(required=false) Long manufacturer,
            @RequestParam(required=false) Long type
    ) {
        Map<String, Object> response = new HashMap<>();
        try {
            List<VVehicle> vehicle = vehicleService.getViewVehicles(id, model, year, manufacturer, type);
            return new ResponseEntity<List<VVehicle>>(vehicle, HttpStatus.OK);
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
