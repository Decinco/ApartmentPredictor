package com.example.apartment_predictor.service;

import com.example.apartment_predictor.model.School;
import com.example.apartment_predictor.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {
    @Autowired
    SchoolRepository schoolRepository;

    public Iterable<School> getSchools() {
        return schoolRepository.findAll();
    }

    public boolean createSchool(School school) {
        schoolRepository.save(school);
        return true;
    }
}
