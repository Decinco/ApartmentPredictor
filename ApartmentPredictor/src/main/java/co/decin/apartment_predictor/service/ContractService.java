package co.decin.apartment_predictor.service;

import co.decin.apartment_predictor.model.Contract;
import co.decin.apartment_predictor.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractService {

    @Autowired
    ContractRepository contractRepository;

    public Iterable<Contract> findAll() {
        return contractRepository.findAll();
    }

    public Contract createContract(Contract contract) {
        return contractRepository.save(contract);
    }

    public Contract updateContract(Contract contract) {
        return contractRepository.save(contract);
    }

    public void deleteContract(String id) {
        contractRepository.deleteById(id);
    }

    public Contract findContractById(String id) {
        Optional<Contract> found = contractRepository.findById(id);
        return found.orElse(null);
    }
}
