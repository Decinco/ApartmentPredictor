package co.decin.apartment_predictor.service;

import co.decin.apartment_predictor.model.Reviewer;
import co.decin.apartment_predictor.repository.ReviewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewerService {

    @Autowired
    ReviewerRepository reviewerRepository;

    public Iterable<Reviewer> findAll() {
        return reviewerRepository.findAll();
    }

    public Reviewer createReviewer(Reviewer reviewer) {
        return reviewerRepository.save(reviewer);
    }

    public Reviewer updateReviewer(Reviewer reviewer) {
        return reviewerRepository.save(reviewer);
    }

    public void deleteReviewer(String id) {
        reviewerRepository.deleteById(id);
    }

    public Reviewer findReviewerById(String id) {
        Optional<Reviewer> found = reviewerRepository.findById(id);
        return found.orElse(null);
    }
}
