package co.decin.apartment_predictor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Contract {

    @Id
    private String id;
    private Date start;
    private Date end;

    @ManyToOne
    private Apartment attachedApartment;

    @ManyToOne
    private Owner owner;

    public Contract() {
    }

    public Contract(String id, Date start, Date end, Apartment attachedApartment, Owner owner) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.attachedApartment = attachedApartment;
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
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
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
