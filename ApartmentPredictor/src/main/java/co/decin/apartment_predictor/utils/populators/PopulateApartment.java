package co.decin.apartment_predictor.utils.populators;

import co.decin.apartment_predictor.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PopulateApartment {
    @Autowired
    ApartmentService apartmentService;

    private int populateApartments() {
        return 0;
    }
}
