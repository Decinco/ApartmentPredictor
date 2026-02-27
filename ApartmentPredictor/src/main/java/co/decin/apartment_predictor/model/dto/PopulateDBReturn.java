package co.decin.apartment_predictor.model.dto;

import co.decin.apartment_predictor.model.*;

import java.util.List;

public class PopulateDBReturn {
    private List<Apartment> apartments;
    private List<Contract> contracts;
    private List<Owner> owners;
    private List<Review> reviews;
    private List<Reviewer> reviewers;
    private List<School> schools;

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public List<Owner> getOwners() {
        return owners;
    }

    public void setOwners(List<Owner> owners) {
        this.owners = owners;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Reviewer> getReviewers() {
        return reviewers;
    }

    public void setReviewers(List<Reviewer> reviewers) {
        this.reviewers = reviewers;
    }

    public List<School> getSchools() {
        return schools;
    }

    public void setSchools(List<School> schools) {
        this.schools = schools;
    }

    public PopulateDBReturn(List<Apartment> apartments, List<Contract> contracts, List<Owner> owners, List<Review> reviews, List<Reviewer> reviewers, List<School> schools) {
        this.apartments = apartments;
        this.contracts = contracts;
        this.owners = owners;
        this.reviews = reviews;
        this.reviewers = reviewers;
        this.schools = schools;
    }
}
