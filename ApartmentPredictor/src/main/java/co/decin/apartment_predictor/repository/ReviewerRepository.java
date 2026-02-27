package co.decin.apartment_predictor.repository;

import co.decin.apartment_predictor.model.Reviewer;
import org.springframework.data.repository.CrudRepository;

public interface ReviewerRepository extends CrudRepository<Reviewer, String> {
}
