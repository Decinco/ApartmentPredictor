package co.decin.apartment_predictor.service;

import co.decin.apartment_predictor.model.Owner;
import co.decin.apartment_predictor.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerService {

    @Autowired
    OwnerRepository ownerRepository;

    public Iterable<Owner> findAll() {
        return ownerRepository.findAll();
    }

    public Owner createOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    public Owner updateOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    public void deleteOwner(String id) {
        ownerRepository.deleteById(id);
    }

    public Owner findOwnerById(String id) {
        Optional<Owner> found = ownerRepository.findById(id);
        return found.orElse(null);
    }
}
