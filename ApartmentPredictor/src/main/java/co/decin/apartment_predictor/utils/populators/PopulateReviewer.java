package co.decin.apartment_predictor.utils.populators;

import co.decin.apartment_predictor.model.Reviewer;
import co.decin.apartment_predictor.service.ReviewerService;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
public class PopulateReviewer {

    @Autowired
    ReviewerService reviewerService;

    public List<Reviewer> populateReviewers(int amount) {
        List<Reviewer> created = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < amount; i++) {
            Reviewer plainReviewer = new Reviewer();
            Faker faker = new Faker(new Random(random.nextInt()));
            Name name = faker.name();

            plainReviewer.setId(UUID.randomUUID().toString());
            plainReviewer.setUsername(name.firstName().toLowerCase() + name.lastName().toLowerCase() + random.nextInt(10, 99)); // Example: lauraperez32
            plainReviewer.setFirstName(name.firstName());
            plainReviewer.setLastName(name.lastName());
            plainReviewer.setEmail(name.firstName().toLowerCase() + "." + name.lastName().toLowerCase() + i + "@decin.co");
            plainReviewer.setAge(random.nextInt(18, 65));

            created.add(reviewerService.createReviewer(plainReviewer));
        }

        return created;
    }
}
