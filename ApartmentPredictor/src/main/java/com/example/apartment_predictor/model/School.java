package com.example.apartment_predictor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class School {

    @Id
    private String id;
    private String name;
    private String educationLevel;
    private String address;
    private double rating;

    @ManyToMany
    private List<Apartment> affectedApartments = new ArrayList<>();

    public School(String id, String name, String educationLevel, String address, double rating) {
        this.id = id;
        this.name = name;
        this.educationLevel = educationLevel;
        this.address = address;
        this.rating = rating;
    }

    public School() {
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

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<Apartment> getAffectedApartments() {
        return affectedApartments;
    }

    public void setAffectedApartments(List<Apartment> affectedApartments) {
        this.affectedApartments = affectedApartments;
    }
}
