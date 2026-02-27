package co.decin.apartment_predictor.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class School {
    @Id
    private String id;
    private String name;
    private List<EducationLevel> levels;
    private String location;
    private Integer rating;
    private boolean isPublic;

    @ManyToMany
    @JsonIgnoreProperties({"reviews", "contracts", "nearbySchools"})
    protected List<Apartment> nearbyApartments = new ArrayList<>();

    public School() {
    }

    public School(String id, String name, List<EducationLevel> levels, String location, Integer rating, boolean isPublic) {
        this.id = id;
        this.name = name;
        this.levels = levels;
        this.location = location;
        this.rating = rating;
        this.isPublic = isPublic;
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

    public List<EducationLevel> getLevels() {
        return levels;
    }

    public void setLevels(List<EducationLevel> levels) {
        this.levels = levels;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    // foreign
    public List<Apartment> getNearbyApartments() {
        return nearbyApartments;
    }

    public void setNearbyApartments(List<Apartment> nearbyApartments) {
        this.nearbyApartments = nearbyApartments;
    }

    @Override
    public String toString() {
        return "School{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", levels=" + levels +
                ", location='" + location + '\'' +
                ", rating=" + rating +
                ", isPublic=" + isPublic +
                '}';
    }
}
