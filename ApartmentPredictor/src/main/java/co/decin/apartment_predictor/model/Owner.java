package co.decin.apartment_predictor.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import javax.crypto.Cipher;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Owner extends User {
    private String nif;
    private String phoneNumber;

    @OneToMany(mappedBy = "owner")
    @JsonIgnoreProperties({"owner", "attachedApartment"})
    private List<Contract> contracts = new ArrayList<>();

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Owner() {
    }

    public Owner(String id, String nif, String phoneNumber) {
        this.id = id;
        this.nif = nif;
        this.phoneNumber = phoneNumber;
    }

    // foreign

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id='" + id + '\'' +
                ", nif='" + nif + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
