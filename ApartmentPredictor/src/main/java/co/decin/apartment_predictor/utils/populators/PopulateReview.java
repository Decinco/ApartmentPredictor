package co.decin.apartment_predictor.utils.populators;

import co.decin.apartment_predictor.model.Apartment;
import co.decin.apartment_predictor.model.Owner;
import co.decin.apartment_predictor.model.Review;
import co.decin.apartment_predictor.model.Reviewer;
import co.decin.apartment_predictor.service.ApartmentService;
import co.decin.apartment_predictor.service.ReviewService;
import co.decin.apartment_predictor.service.ReviewerService;
import com.github.javafaker.Faker;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
public class PopulateReview {

    @Autowired
    ReviewService reviewService;

    @Autowired
    ApartmentService apartmentService;

    @Autowired
    ReviewerService reviewerService;

    public List<Review> populateReviews(int amount) {
        List<Review> created = new ArrayList<>();
        Random random = new Random();
        Faker faker = new Faker();

        List<Apartment> apartments =  IterableUtils.toList(apartmentService.findAll());
        List<Reviewer> reviewers =  IterableUtils.toList(reviewerService.findAll());

        for (int i = 0; i < amount; i++) {
            Review plainReview = new Review();
            Date postDate = faker.date().past(1100, TimeUnit.DAYS);

            plainReview.setId(UUID.randomUUID().toString());
            plainReview.setTitle(faker.lorem().characters(3, 24));
            plainReview.setContents(faker.lorem().characters(50, 150));
            plainReview.setRating(random.nextInt(1, 6));
            plainReview.setApartment(apartments.get(random.nextInt(apartments.size())));
            plainReview.setDate(postDate);
            plainReview.setReviewer(reviewers.get(random.nextInt(reviewers.size())));

            created.add(reviewService.createReview(plainReview));
        }

        return created;
    }
}
