package co.decin.apartment_predictor.repository;

import org.springframework.data.repository.CrudRepository;
import co.decin.apartment_predictor.model.Apartment;

public interface ApartmentRepository extends CrudRepository<Apartment, String> {

}
