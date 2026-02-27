package co.decin.apartment_predictor.controller;

import co.decin.apartment_predictor.model.Owner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("aptPredictor/v1/populate")
public class PopulatorRestController {
    @PostMapping("")
    public ResponseEntity<String> createOwner(@RequestBody Map<String, Integer> amounts) {

        return ResponseEntity.ok().body("WIP");
    }

}
