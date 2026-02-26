package co.decin.apartment_predictor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Reviewer extends User {
    private String id;
    private String username;
    private String date;

    @OneToMany
    private List<Review> reviews = new ArrayList<>();

    public Reviewer() {
    }

    public Reviewer(String id, String username, String date) {
        this.id = id;
        this.username = username;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // foreign
    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Reviewer{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
