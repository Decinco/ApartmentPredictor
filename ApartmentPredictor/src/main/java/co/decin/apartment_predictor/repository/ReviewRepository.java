package co.decin.apartment_predictor.repository;

import co.decin.apartment_predictor.model.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, String> {
}
