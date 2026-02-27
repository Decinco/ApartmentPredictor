package co.decin.apartment_predictor.repository;

import co.decin.apartment_predictor.model.Contract;
import org.springframework.data.repository.CrudRepository;

public interface ContractRepository extends CrudRepository<Contract, String> {
}
