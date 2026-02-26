package co.decin.apartment_predictor.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Service;

@Entity
public class Review {
    @Id
    private String id;
    private String title;
    private String contents;
    private Integer rating;

    @ManyToOne
    private Apartment apartment;

    public Review() {
    }

    public Review(String id, String title, String contents, Integer rating, Apartment apartment) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.rating = rating;
        this.apartment = apartment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    // foreign
    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", rating=" + rating +
                '}';
    }
}
