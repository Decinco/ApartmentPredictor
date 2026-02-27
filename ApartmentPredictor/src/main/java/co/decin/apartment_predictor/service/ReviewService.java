package co.decin.apartment_predictor.service;

import co.decin.apartment_predictor.model.Apartment;
import co.decin.apartment_predictor.model.Review;
import co.decin.apartment_predictor.repository.ApartmentRepository;
import co.decin.apartment_predictor.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    ApartmentRepository apartmentRepository;

    @Autowired
    ReviewRepository reviewRepository;

    public Iterable<Review> findAll() {
        return reviewRepository.findAll();
    }

    public Review createReview(Review review){
        return reviewRepository.save(review);
    }

    public Review updateReview (Review review){
        return reviewRepository.save(review);
    }

    public void deleteApartment (String id){
        reviewRepository.deleteById(id);
    }

    public Review findApartmentById (String id){
        Optional<Review> found = reviewRepository.findById(id);
        return found.orElse(null);
    }

    // foreign
    public void bindReviewToApartment (String idReview, String idApartment) {
        // todo
    }
}
