package com.example.apartment_predictor.controller;

import com.example.apartment_predictor.model.School;
import com.example.apartment_predictor.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("aptPredictor/v1/schools")
public class SchoolRestController {
    @Autowired
    SchoolService schoolService;

    // default mapping at aptPredictor/v1/schools
    @GetMapping("")
    public ResponseEntity<Iterable<School>> getAllApartments(){
        return ResponseEntity.ok().body(schoolService.getSchools());
        //return apartmentService.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<School> createSchool(@RequestBody School school){
        schoolService.createSchool(school);
        return ResponseEntity.ok().body(school);
    }

}
