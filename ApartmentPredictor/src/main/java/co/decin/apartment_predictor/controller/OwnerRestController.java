package co.decin.apartment_predictor.controller;

import co.decin.apartment_predictor.model.Owner;
import co.decin.apartment_predictor.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("aptPredictor/v1/owners")
public class OwnerRestController {

    @Autowired
    OwnerService ownerService;

    @GetMapping("")
    public ResponseEntity<Iterable<Owner>> getAllOwners() {
        return ResponseEntity.ok().body(ownerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable String id) {
        return ResponseEntity.ok().body(ownerService.findOwnerById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Owner> createOwner(@RequestBody Owner owner) {
        return ResponseEntity.ok().body(ownerService.createOwner(owner));
    }

    @PutMapping("/update")
    public ResponseEntity<Owner> updateOwner(@RequestBody Owner owner) {
        return ResponseEntity.ok().body(ownerService.updateOwner(owner));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOwnerById(@PathVariable String id) {
        ownerService.deleteOwner(id);
        return ResponseEntity.ok().body("Deleted owner " + id + " successfully");
    }
}
