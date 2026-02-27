package co.decin.apartment_predictor.controller;

import co.decin.apartment_predictor.model.Review;
import co.decin.apartment_predictor.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("aptPredictor/v1/reviews")
public class ReviewRestController {

    @Autowired
    ReviewService reviewService;

    @GetMapping("")
    public ResponseEntity<Iterable<Review>> getAllReviews() {
        return ResponseEntity.ok().body(reviewService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable String id) {
        return ResponseEntity.ok().body(reviewService.findReviewById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        return ResponseEntity.ok().body(reviewService.createReview(review));
    }

    @PutMapping("/update")
    public ResponseEntity<Review> updateReview(@RequestBody Review review) {
        return ResponseEntity.ok().body(reviewService.updateReview(review));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteReviewById(@PathVariable String id) {
        reviewService.deleteReview(id);
        return ResponseEntity.ok().body("Deleted review " + id + " successfully");
    }
}
