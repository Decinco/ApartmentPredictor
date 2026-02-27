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

    // default mapping at aptPredictor/v1/apartments
    @GetMapping("")
    public ResponseEntity<Iterable<Apartment>> getAllApartments(){
        return ResponseEntity.ok().body(apartmentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apartment> getApartmentById(@PathVariable String id){
        return ResponseEntity.ok().body(apartmentService.findApartmentById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Apartment> createApartment(@RequestBody Apartment apartment){
        //apartment.setId(UUID.randomUUID().toString());
        return ResponseEntity.ok().body(apartmentService.createApartment(apartment));
    }

    @PutMapping("/update")
    public ResponseEntity<Apartment> updateApartment(@RequestBody Apartment apartment){
        return ResponseEntity.ok().body(apartmentService.updateApartment(apartment));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteApartmentById(@PathVariable String id){
            apartmentService.deleteApartment(id);
            return ResponseEntity.ok().body("Deleted apartment " + id + " successfully");
    }
}
