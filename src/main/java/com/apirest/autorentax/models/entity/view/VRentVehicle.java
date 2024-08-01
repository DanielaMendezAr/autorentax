package com.apirest.autorentax.models.entity.view;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;

@Entity
@NamedStoredProcedureQuery(
        name = "fgetrentsvehicles",
        procedureName = "fgetrentsvehicles",
        resultClasses = VRentVehicle.class,
        parameters = {})
public class VRentVehicle {

    private static final long serialVersionUID = 821779879550881262L;

    @Id
    private Long id;
    private String name_client;
    private String phone_client;
    private String email_client;
    private String model_vehicle;
    private String year_vehicle;
    private String manufacturer_vehicle;
    private String type_vehicle;
    private String description_vehicle;
    private String price_total;
    private String order_date;
    private String rental_time;
    private String status;
    private String initial_date;
    private String final_date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_client() {
        return name_client;
    }

    public void setName_client(String name_client) {
        this.name_client = name_client;
    }

    public String getPhone_client() {
        return phone_client;
    }

    public void setPhone_client(String phone_client) {
        this.phone_client = phone_client;
    }

    public String getEmail_client() {
        return email_client;
    }

    public void setEmail_client(String email_client) {
        this.email_client = email_client;
    }

    public String getModel_vehicle() {
        return model_vehicle;
    }

    public void setModel_vehicle(String model_vehicle) {
        this.model_vehicle = model_vehicle;
    }

    public String getYear_vehicle() {
        return year_vehicle;
    }

    public void setYear_vehicle(String year_vehicle) {
        this.year_vehicle = year_vehicle;
    }

    public String getManufacturer_vehicle() {
        return manufacturer_vehicle;
    }

    public void setManufacturer_vehicle(String manufacturer_vehicle) {
        this.manufacturer_vehicle = manufacturer_vehicle;
    }

    public String getType_vehicle() {
        return type_vehicle;
    }

    public void setType_vehicle(String type_vehicle) {
        this.type_vehicle = type_vehicle;
    }

    public String getDescription_vehicle() {
        return description_vehicle;
    }

    public void setDescription_vehicle(String description_vehicle) {
        this.description_vehicle = description_vehicle;
    }

    public String getPrice_total() {
        return price_total;
    }

    public void setPrice_total(String price_total) {
        this.price_total = price_total;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getRental_time() {
        return rental_time;
    }

    public void setRental_time(String rental_time) {
        this.rental_time = rental_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInitial_date() {
        return initial_date;
    }

    public void setInitial_date(String initial_date) {
        this.initial_date = initial_date;
    }

    public String getFinal_date() {
        return final_date;
    }

    public void setFinal_date(String final_date) {
        this.final_date = final_date;
    }
}
