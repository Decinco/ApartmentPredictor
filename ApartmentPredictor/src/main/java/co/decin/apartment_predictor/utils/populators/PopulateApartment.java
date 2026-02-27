package co.decin.apartment_predictor.utils.populators;

import co.decin.apartment_predictor.model.Apartment;
import co.decin.apartment_predictor.model.FurnishingStatus;
import co.decin.apartment_predictor.service.ApartmentService;
import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
public class PopulateApartment {

    @Autowired
    ApartmentService apartmentService;

    public List<Apartment> populateApartments(int amount) {
        List<Apartment> created = new ArrayList<>();
        Random random = new Random();
        Faker faker = new Faker();

        FurnishingStatus[] furnishingStatuses = FurnishingStatus.values();

        for (int i = 0; i < amount; i++) {
            Apartment apartment = new Apartment();
            Address apartmentAddress = faker.address();

            apartment.setId(UUID.randomUUID().toString());
            apartment.setName("Apartment in " + apartmentAddress.cityName());
            apartment.setDescription("An amazing apartment located in the " + apartmentAddress.cityName() + ", " + apartmentAddress.state());
            apartment.setLocation(apartmentAddress.fullAddress());
            apartment.setArea(random.nextInt(50, 251));
            apartment.setBedrooms(random.nextInt(1, 5));
            apartment.setBathrooms(random.nextInt(1, 3));
            apartment.setStories(random.nextInt(1, 5));
            apartment.setGuestroom(random.nextBoolean());
            apartment.setBasement(random.nextBoolean());
            apartment.setWaterHeating(random.nextBoolean());
            apartment.setAirConditioning(random.nextBoolean());
            apartment.setParking(random.nextBoolean());
            apartment.setFurnishingStatus(furnishingStatuses[random.nextInt(furnishingStatuses.length)]);

            apartmentService.createApartment(apartment);
            created.add(apartmentService.createApartment(apartment));
        }

        return created;
    }
}
