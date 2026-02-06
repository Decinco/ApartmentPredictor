package com.example.apartment_predictor.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Apartment {

    @Id
    protected String id;
    private String name;
    private Long price;
    protected Integer area;
    protected Integer bedrooms;
    private Integer bathrooms;
    private Integer stories;
    private boolean guestroom;
    private boolean basement;
    private boolean hotwaterheating;
    private boolean airconditioning;
    private boolean parking;
    private FurnishingStatus furnishingstatus;

    public Apartment(String id, String name, Long price, Integer area, Integer bedrooms, Integer bathrooms, Integer stories, boolean guestroom, boolean basement, boolean hotwaterheating, boolean airconditioning, boolean parking, FurnishingStatus furnishingstatus) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.area = area;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.stories = stories;
        this.guestroom = guestroom;
        this.basement = basement;
        this.hotwaterheating = hotwaterheating;
        this.airconditioning = airconditioning;
        this.parking = parking;
        this.furnishingstatus = furnishingstatus;
    }

    public Apartment() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public Integer getStories() {
        return stories;
    }

    public void setStories(Integer stories) {
        this.stories = stories;
    }

    public boolean isGuestroom() {
        return guestroom;
    }

    public void setGuestroom(boolean guestroom) {
        this.guestroom = guestroom;
    }

    public boolean isBasement() {
        return basement;
    }

    public void setBasement(boolean basement) {
        this.basement = basement;
    }

    public boolean isHotwaterheating() {
        return hotwaterheating;
    }

    public void setHotwaterheating(boolean hotwaterheating) {
        this.hotwaterheating = hotwaterheating;
    }

    public boolean isAirconditioning() {
        return airconditioning;
    }

    public void setAirconditioning(boolean airconditioning) {
        this.airconditioning = airconditioning;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public String getFurnishingstatus() {
        return furnishingstatus.getLiteral();
    }

    @JsonIgnore
    public FurnishingStatus getRawFurnishingstatus() {
        return furnishingstatus;
    }

    public void setFurnishingstatus(FurnishingStatus furnishingstatus) {
        this.furnishingstatus = furnishingstatus;
    }

    // Funciones adicionales
    public double calculatePrice() {return 0;}
}
