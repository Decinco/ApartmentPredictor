package co.decin.apartment_predictor.controller;

import co.decin.apartment_predictor.model.School;
import co.decin.apartment_predictor.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("aptPredictor/v1/schools")
public class SchoolRestController {

    @Autowired
    SchoolService schoolService;

    @GetMapping("")
    public ResponseEntity<Iterable<School>> getAllSchools() {
        return ResponseEntity.ok().body(schoolService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<School> getSchoolById(@PathVariable String id) {
        return ResponseEntity.ok().body(schoolService.findSchoolById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<School> createSchool(@RequestBody School school) {
        return ResponseEntity.ok().body(schoolService.createSchool(school));
    }

    @PutMapping("/update")
    public ResponseEntity<School> updateSchool(@RequestBody School school) {
        return ResponseEntity.ok().body(schoolService.updateSchool(school));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSchoolById(@PathVariable String id) {
        schoolService.deleteSchool(id);
        return ResponseEntity.ok().body("Deleted school " + id + " successfully");
    }
}
