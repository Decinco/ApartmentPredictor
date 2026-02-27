package co.decin.apartment_predictor.controller;

import co.decin.apartment_predictor.model.Contract;
import co.decin.apartment_predictor.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("aptPredictor/v1/contracts")
public class ContractRestController {

    @Autowired
    ContractService contractService;

    @GetMapping("")
    public ResponseEntity<Iterable<Contract>> getAllContracts() {
        return ResponseEntity.ok().body(contractService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contract> getContractById(@PathVariable String id) {
        return ResponseEntity.ok().body(contractService.findContractById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Contract> createContract(@RequestBody Contract contract) {
        return ResponseEntity.ok().body(contractService.createContract(contract));
    }

    @PutMapping("/update")
    public ResponseEntity<Contract> updateContract(@RequestBody Contract contract) {
        return ResponseEntity.ok().body(contractService.updateContract(contract));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContractById(@PathVariable String id) {
        contractService.deleteContract(id);
        return ResponseEntity.ok().body("Deleted contract " + id + " successfully");
    }
}
