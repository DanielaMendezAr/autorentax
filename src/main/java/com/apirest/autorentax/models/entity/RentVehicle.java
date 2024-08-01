package com.apirest.autorentax.models.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "rents_vehicles")
public class RentVehicle implements Serializable {

    private static final long serialVersionUID = 27401832847645805L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "client null")
    @Column(name="client_id")
    private Long client;

    @NotNull(message = "vehicle null")
    @Column(name="vehicle_id")
    private Long vehicle;

    @NotNull(message = "order date null")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime order_date;

    @NotNull(message = "rental time null")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private LocalTime rental_time;

    @NotNull(message = "status null")
    @Column(name="status_id")
    private Long status;

    @NotNull(message = "initial date null")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime initial_date;

    @NotNull(message = "final date null")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime final_date;

    @PrePersist
    protected void onCreate() {
        if (order_date == null) {
            order_date = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull Long getClient() {
        return client;
    }

    public void setClient(@NotNull Long client) {
        this.client = client;
    }

    public @NotNull Long getVehicle() {
        return vehicle;
    }

    public void setVehicle(@NotNull Long vehicle) {
        this.vehicle = vehicle;
    }

    public @NotNull LocalDateTime getOrder_date() {
        return order_date;
    }

    public void setOrder_date(@NotNull LocalDateTime order_date) {
        this.order_date = order_date;
    }

    public @NotNull LocalTime getRental_time() {
        return rental_time;
    }

    public void setRental_time(@NotNull LocalTime rental_time) {
        this.rental_time = rental_time;
    }

    public @NotNull Long getStatus() {
        return status;
    }

    public void setStatus(@NotNull Long status) {
        this.status = status;
    }

    public @NotNull LocalDateTime getInitial_date() {
        return initial_date;
    }

    public void setInitial_date(@NotNull LocalDateTime initial_date) {
        this.initial_date = initial_date;
    }

    public @NotNull LocalDateTime getFinal_date() {
        return final_date;
    }

    public void setFinal_date(@NotNull LocalDateTime final_date) {
        this.final_date = final_date;
    }
}
