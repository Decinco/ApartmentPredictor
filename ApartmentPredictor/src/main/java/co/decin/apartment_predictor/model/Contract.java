package co.decin.apartment_predictor.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Contract {

    @Id
    private String id;
    private Date startDate;
    private Date endDate;

    @ManyToOne
    @JsonIgnoreProperties({"reviews", "contracts", "nearbySchools"})
    private Apartment attachedApartment;

    @ManyToOne
    @JsonIgnoreProperties({"contracts"})
    private Owner owner;

    public Contract() {
    }

    public Contract(String id, Date startDate, Date endDate, Apartment attachedApartment, Owner owner) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.attachedApartment = attachedApartment;
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    // foreign


    public Apartment getAttachedApartment() {
        return attachedApartment;
    }

    public void setAttachedApartment(Apartment attachedApartment) {
        this.attachedApartment = attachedApartment;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id='" + id + '\'' +
                ", start=" + startDate +
                ", end=" + endDate +
                '}';
    }
}
