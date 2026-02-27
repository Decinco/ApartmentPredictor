package co.decin.apartment_predictor.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Service;

import java.util.Date;

@Entity
public class Review {
    @Id
    private String id;
    private String title;
    private String contents;
    private Integer rating;
    private Date date;

    @ManyToOne
    private Apartment apartment;

    @ManyToOne
    private Reviewer reviewer;

    public Review() {
    }

    public Review(String id, String title, String contents, Integer rating, Date date, Apartment apartment, Reviewer reviewer) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.rating = rating;
        this.date = date;
        this.apartment = apartment;
        this.reviewer = reviewer;
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

    public Reviewer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
                ", date=" + date +
                ", apartment=" + apartment +
                ", reviewer=" + reviewer +
                '}';
    }
}
