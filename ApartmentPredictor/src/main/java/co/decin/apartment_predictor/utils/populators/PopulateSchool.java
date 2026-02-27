package co.decin.apartment_predictor.utils.populators;

import co.decin.apartment_predictor.model.Apartment;
import co.decin.apartment_predictor.model.EducationLevel;
import co.decin.apartment_predictor.model.School;
import co.decin.apartment_predictor.service.ApartmentService;
import co.decin.apartment_predictor.service.SchoolService;
import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PopulateSchool {

    @Autowired
    SchoolService schoolService;

    @Autowired
    ApartmentService apartmentService;

    public List<School> populateSchools(int amount) {
        List<School> created = new ArrayList<>();
        Random random = new Random();

        EducationLevel[] allLevels = EducationLevel.values();

        for (int i = 0; i < amount; i++) {
            Faker faker = new Faker(new Random(random.nextInt()));
            School plainSchool = new School();
            Address address = faker.address();

            plainSchool.setId(UUID.randomUUID().toString());
            plainSchool.setName("School in " + address.cityName());
            plainSchool.setLocation(address.fullAddress());
            plainSchool.setRating(random.nextInt(1, 11));
            plainSchool.setPublic(random.nextBoolean());

            int levelCount = random.nextInt(1, 4);
            List<EducationLevel> levels = new ArrayList<>();
            for (int j = 0; j < levelCount; j++) {
                EducationLevel level = allLevels[random.nextInt(allLevels.length)];
                if (!levels.contains(level)) levels.add(level);
            }
            plainSchool.setLevels(levels);

            plainSchool.setNearbyApartments(generateNearbyApartments(random));

            created.add(schoolService.createSchool(plainSchool));
        }

        return created;
    }

    public List<Apartment> generateNearbyApartments(Random random) {
        HashMap<String, Apartment> addedApartments = new HashMap<>();
        List<Apartment> allApartments = IterableUtils.toList(apartmentService.findAll());

        int storedApartments = allApartments.size();
        int maxApartmentsGenerated = Math.max(storedApartments, 5);
        int apartmentsGeneratedAmount = random.nextInt(maxApartmentsGenerated);

        for (int i = 0; i < apartmentsGeneratedAmount; i++) {
            int apartmentIndex = random.nextInt(storedApartments);
            Apartment nextApartment = allApartments.get(apartmentIndex);

            addedApartments.put(nextApartment.getId(), nextApartment);
        }

        return List.copyOf(addedApartments.values());
    }
}
