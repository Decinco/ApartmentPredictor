package co.decin.apartment_predictor.repository;

import co.decin.apartment_predictor.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
