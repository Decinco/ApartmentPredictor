package co.decin.apartment_predictor.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Apartment {
    @Id
    protected String id;
    protected String name;
    protected String description;
    protected String location;
    protected Integer area;
    // price is calculated on query
    protected Integer bedrooms;
    protected Integer bathrooms;
    protected Integer stories;
    protected boolean guestroom;
    protected boolean basement;
    protected boolean waterHeating;
    protected boolean airConditioning;
    protected boolean parking;
    protected FurnishingStatus furnishingStatus;

    @ManyToMany
    protected List<School> nearbySchools = new ArrayList<>();

    @OneToMany
    protected List<Review> reviews = new ArrayList<>();

    @OneToMany
    protected List<Contract> contracts = new ArrayList<>();

    public Apartment(String id, String name, String description, String location, Integer area, Integer bedrooms, Integer bathrooms, Integer stories, boolean guestroom, boolean basement, boolean waterHeating, boolean airConditioning, boolean parking, FurnishingStatus furnishingStatus) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.area = area;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.stories = stories;
        this.guestroom = guestroom;
        this.basement = basement;
        this.waterHeating = waterHeating;
        this.airConditioning = airConditioning;
        this.parking = parking;
        this.furnishingStatus = furnishingStatus;
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
        return calculatePrice();
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

    public boolean isWaterHeating() {
        return waterHeating;
    }

    public void setWaterHeating(boolean waterHeating) {
        this.waterHeating = waterHeating;
    }

    public boolean isAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public String getFurnishingStatus() {
        return furnishingStatus.getLiteral();
    }

    @JsonIgnore
    public FurnishingStatus getRawFurnishingstatus() {
        return furnishingStatus;
    }

    public void setFurnishingStatus(FurnishingStatus furnishingStatus) {
        this.furnishingStatus = furnishingStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // foreign
    public List<School> getNearbySchools() {
        return nearbySchools;
    }

    public void setNearbySchools(List<School> nearbySchools) {
        this.nearbySchools = nearbySchools;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", area=" + area +
                ", bedrooms=" + bedrooms +
                ", bathrooms=" + bathrooms +
                ", stories=" + stories +
                ", guestroom=" + guestroom +
                ", basement=" + basement +
                ", waterHeating=" + waterHeating +
                ", airConditioning=" + airConditioning +
                ", parking=" + parking +
                ", furnishingStatus=" + furnishingStatus +
                '}';
    }

    // Funciones adicionales
    public Long calculatePrice() {

        long price = 0L;

        price += area * 1500;
        price = Math.round(price * (1 + (stories - 1) * 0.15)); // For each additional story, the price of each m2 gets multiplied.
        price += bedrooms * 7500;
        price += bathrooms * 5500;
        price += guestroom ? 10000 : 0;
        price += waterHeating ? 15000 : 0;
        price += airConditioning ? 20000 : 0;
        price += parking ? 30000 : 0;
        price += basement ? 45000 : 0;

        switch (furnishingStatus) {
            case PARTIALLY_FURNISHED ->  price += 3000;
            case FULLY_FURNISHED -> price += 8500;
        }

        // Simplified inflation simulation.
        // Applies a multiplier based on the amount of days that passed since 1970
        double multiplier;
        int daysPassed;
        Instant currentTime = Instant.now();

        daysPassed = (int) Math.floor((double) currentTime.getEpochSecond() / 86400);
        multiplier = 1 + daysPassed * 0.000075;

        return Math.round(price * multiplier);
    }
}
