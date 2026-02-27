package co.decin.apartment_predictor.utils.populators;

import co.decin.apartment_predictor.model.Owner;
import co.decin.apartment_predictor.service.OwnerService;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
public class PopulateOwner {

    @Autowired
    OwnerService ownerService;

    public List<Owner> populateOwners(int amount) {
        List<Owner> created = new ArrayList<>();
        Random random = new Random();
        Faker faker = new Faker();

        for (int i = 0; i < amount; i++) {
            Owner plainOwner = new Owner();
            Name name = faker.name();

            plainOwner.setId(UUID.randomUUID().toString());
            plainOwner.setFirstName(name.firstName());
            plainOwner.setLastName(name.lastName());
            plainOwner.setEmail(name.firstName().toLowerCase() + "." + name.lastName().toLowerCase() + i + "@decin.co");
            plainOwner.setAge(random.nextInt(25, 75));

            plainOwner.setNif(faker.regexify("^[0-9]{8}[A-Z]$"));
            plainOwner.setPhoneNumber(faker.regexify("^(6)[ -]*([0-9][ -]*){8}$"));

            created.add(ownerService.createOwner(plainOwner));
        }

        return created;
    }
}
