package co.decin.apartment_predictor.service;

import co.decin.apartment_predictor.model.Apartment;
import co.decin.apartment_predictor.repository.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApartmentService {
    @Autowired
    ApartmentRepository apartmentRepository;

    public Iterable<Apartment> findAll() {
        return apartmentRepository.findAll();
    }

    public Apartment createApartment(Apartment apartment){
        return apartmentRepository.save(apartment);
    }

    public Apartment updateApartment (Apartment apartment){
        return apartmentRepository.save(apartment);
    }

    public void deleteApartment (String id){
        apartmentRepository.deleteById(id);
    }

    public Apartment findApartmentById (String id){
        Optional<Apartment> found = apartmentRepository.findById(id);
        return found.orElse(null);
    }
}
