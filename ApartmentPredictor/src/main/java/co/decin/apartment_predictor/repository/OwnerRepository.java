package co.decin.apartment_predictor.repository;

import co.decin.apartment_predictor.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, String> {
}
