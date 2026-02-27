package co.decin.apartment_predictor.model.dto;

public class PopulateDBRequest {
    private int apartments;
    private int contracts;
    private int owners;
    private int reviews;
    private int reviewers;
    private int schools;

    public int getSchools() {
        return schools;
    }

    public void setSchools(int schools) {
        this.schools = schools;
    }

    public int getReviewers() {
        return reviewers;
    }

    public void setReviewers(int reviewers) {
        this.reviewers = reviewers;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    public int getOwners() {
        return owners;
    }

    public void setOwners(int owners) {
        this.owners = owners;
    }

    public int getContracts() {
        return contracts;
    }

    public void setContracts(int contracts) {
        this.contracts = contracts;
    }

    public int getApartments() {
        return apartments;
    }

    public void setApartments(int apartments) {
        this.apartments = apartments;
    }
}
