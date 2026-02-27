package co.decin.apartment_predictor.controller;

import co.decin.apartment_predictor.model.Reviewer;
import co.decin.apartment_predictor.service.ReviewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("aptPredictor/v1/reviewers")
public class ReviewerRestController {

    @Autowired
    ReviewerService reviewerService;

    @GetMapping("")
    public ResponseEntity<Iterable<Reviewer>> getAllReviewers() {
        return ResponseEntity.ok().body(reviewerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reviewer> getReviewerById(@PathVariable String id) {
        return ResponseEntity.ok().body(reviewerService.findReviewerById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Reviewer> createReviewer(@RequestBody Reviewer reviewer) {
        return ResponseEntity.ok().body(reviewerService.createReviewer(reviewer));
    }

    @PutMapping("/update")
    public ResponseEntity<Reviewer> updateReviewer(@RequestBody Reviewer reviewer) {
        return ResponseEntity.ok().body(reviewerService.updateReviewer(reviewer));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteReviewerById(@PathVariable String id) {
        reviewerService.deleteReviewer(id);
        return ResponseEntity.ok().body("Deleted reviewer " + id + " successfully");
    }
}
