package co.decin.apartment_predictor.utils;

import co.decin.apartment_predictor.model.Apartment;
import co.decin.apartment_predictor.model.School;
import co.decin.apartment_predictor.repository.SchoolRepository;
import co.decin.apartment_predictor.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class PopulateDB {

    private void populateAll() {

    }

    @Autowired
    ApartmentService apartmentService;

    @Autowired
    SchoolRepository schoolRepository;

    //todo: all methods MUST return the objects created

}
