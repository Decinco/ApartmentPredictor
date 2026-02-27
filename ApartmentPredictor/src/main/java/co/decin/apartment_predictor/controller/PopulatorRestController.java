package co.decin.apartment_predictor.controller;

import co.decin.apartment_predictor.model.Owner;
import co.decin.apartment_predictor.model.PopulateDBRequest;
import co.decin.apartment_predictor.model.PopulateDBReturn;
import co.decin.apartment_predictor.utils.PopulateDB;
import co.decin.apartment_predictor.utils.populators.PopulateApartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
