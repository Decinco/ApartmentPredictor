package co.decin.apartment_predictor.service;

import co.decin.apartment_predictor.model.School;
import co.decin.apartment_predictor.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SchoolService {

    @Autowired
    SchoolRepository schoolRepository;

    public Iterable<School> findAll() {
        return schoolRepository.findAll();
    }

    public School createSchool(School school) {
        return schoolRepository.save(school);
    }

    public School updateSchool(School school) {
        return schoolRepository.save(school);
    }

    public void deleteSchool(String id) {
        schoolRepository.deleteById(id);
    }

    public School findSchoolById(String id) {
        Optional<School> found = schoolRepository.findById(id);
        return found.orElse(null);
    }
}
