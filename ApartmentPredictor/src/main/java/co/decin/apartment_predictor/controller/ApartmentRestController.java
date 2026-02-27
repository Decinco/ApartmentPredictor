package co.decin.apartment_predictor.controller;

import co.decin.apartment_predictor.model.Apartment;
import co.decin.apartment_predictor.service.ApartmentService;
import co.decin.apartment_predictor.utils.PopulateDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("aptPredictor/v1/apartments")
public class ApartmentRestController {

    @Autowired
    ApartmentService apartmentService;

    @Autowired
    PopulateDB populateDB;

    // default mapping at aptPredictor/v1/apartments
    @GetMapping("")
    public ResponseEntity<Iterable<Apartment>> getAllApartments(){
        return ResponseEntity.ok().body(apartmentService.findAll());
        //return apartmentService.findAll();
    }

    @GetMapping("/{id}")
    public Apartment getApartmentById(@PathVariable String id){
        return apartmentService.findApartmentById(id);
    }

    @PostMapping("/create")
    public Apartment createApartment(@RequestBody Apartment apartment){
        //apartment.setId(UUID.randomUUID().toString());
        return apartmentService.createApartment(apartment);
    }

    @PutMapping("/update")
    public Apartment updateApartment(@RequestBody Apartment apartment){
        return apartmentService.updateApartment(apartment);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteApartmentById(@PathVariable String id){
        apartmentService.deleteApartment(id);
    }
}
