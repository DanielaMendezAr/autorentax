package com.apirest.autorentax.models.entity.view;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.math.BigDecimal;
import java.time.Year;

@Entity
@NamedStoredProcedureQuery(
        name = "fgetvehicles",
        procedureName = "fgetvehicles",
        resultClasses = VVehicle.class,
        parameters = {})
public class VVehicle {

    private static final long serialVersionUID = 8217798799908827062L;

    @Id
    private Long id;
    private String model;
    private Year year;
    private String manufacturer;
    private String type;
    private String description;
    private BigDecimal price;
    private Boolean available;
    private Long total;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
