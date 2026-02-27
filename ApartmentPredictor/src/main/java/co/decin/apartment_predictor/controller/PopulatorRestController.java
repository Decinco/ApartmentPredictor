package co.decin.apartment_predictor.controller;

import co.decin.apartment_predictor.model.dto.PopulateDBRequest;
import co.decin.apartment_predictor.model.dto.PopulateDBReturn;
import co.decin.apartment_predictor.utils.PopulateDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("aptPredictor/v1/populate")
public class PopulatorRestController {
    @Autowired
    private PopulateDB populateDB;

    @PostMapping("")
    public ResponseEntity<PopulateDBReturn> createOwner(@RequestBody PopulateDBRequest amounts) {
        populateDB.populateAll(amounts);

        return ResponseEntity.ok().body(populateDB.populateAll(amounts)); // clean! yay!
    }

}
