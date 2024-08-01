package com.apirest.autorentax.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.PrePersist;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class RentVehicleDTO {

    private Long vehicle;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime order_date;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime rental_time;

    private Long status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime initial_date;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime final_date;

    @PrePersist
    protected void onCreate() {
        if (order_date == null) {
            order_date = LocalDateTime.now();
        }
    }

    private String name_client;
    private String lastname_client;
    private String number_phone_client;
    private String email_client;

    public Long getVehicle() {
        return vehicle;
    }

    public void setVehicle(Long vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDateTime order_date) {
        this.order_date = order_date;
    }

    public LocalTime getRental_time() {
        return rental_time;
    }

    public void setRental_time(LocalTime rental_time) {
        this.rental_time = rental_time;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public LocalDateTime getInitial_date() {
        return initial_date;
    }

    public void setInitial_date(LocalDateTime initial_date) {
        this.initial_date = initial_date;
    }

    public LocalDateTime getFinal_date() {
        return final_date;
    }

    public void setFinal_date(LocalDateTime final_date) {
        this.final_date = final_date;
    }

    public String getName_client() {
        return name_client;
    }

    public void setName_client(String name_client) {
        this.name_client = name_client;
    }

    public String getLastname_client() {
        return lastname_client;
    }

    public void setLastname_client(String lastname_client) {
        this.lastname_client = lastname_client;
    }

    public String getNumber_phone_client() {
        return number_phone_client;
    }

    public void setNumber_phone_client(String number_phone_client) {
        this.number_phone_client = number_phone_client;
    }

    public String getEmail_client() {
        return email_client;
    }

    public void setEmail_client(String email_client) {
        this.email_client = email_client;
    }
}
