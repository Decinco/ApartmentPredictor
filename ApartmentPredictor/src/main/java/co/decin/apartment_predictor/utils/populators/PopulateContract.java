package co.decin.apartment_predictor.utils.populators;

import co.decin.apartment_predictor.model.Apartment;
import co.decin.apartment_predictor.model.Contract;
import co.decin.apartment_predictor.model.Owner;
import co.decin.apartment_predictor.service.ApartmentService;
import co.decin.apartment_predictor.service.ContractService;
import co.decin.apartment_predictor.service.OwnerService;
import com.github.javafaker.Faker;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
public class PopulateContract {

    @Autowired
    ContractService contractService;

    @Autowired
    ApartmentService apartmentService;

    @Autowired
    OwnerService ownerService;

    public List<Contract> populateContracts(int amount) {
        List<Contract> created = new ArrayList<>();
        Random random = new Random();

        List<Apartment> apartments =  IterableUtils.toList(apartmentService.findAll());
        List<Owner> owners =  IterableUtils.toList(ownerService.findAll());

        Faker faker = new Faker();

        for (int i = 0; i < amount; i++) {
            Contract plainContract = new Contract();
            Date initialDate = faker.date().past(1100, TimeUnit.DAYS);

            plainContract.setId(UUID.randomUUID().toString());

            plainContract.setStartDate(initialDate);
            plainContract.setEndDate(faker.date().future(240, TimeUnit.DAYS, initialDate));

            plainContract.setAttachedApartment(apartments.get(random.nextInt(apartments.size())));
            plainContract.setOwner(owners.get(random.nextInt(owners.size())));

            created.add(contractService.createContract(plainContract));
        }

        return created;
    }
}
