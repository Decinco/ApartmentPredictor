package co.decin.apartment_predictor.repository;

import org.hibernate.mapping.Property;
import org.springframework.data.repository.CrudRepository;

public interface PropertyContractRepository extends CrudRepository<Property, String> {
}
