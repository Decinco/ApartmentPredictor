package co.decin.apartment_predictor;

import co.decin.apartment_predictor.model.Apartment;
import co.decin.apartment_predictor.model.Review;
import co.decin.apartment_predictor.repository.ApartmentRepository;
import co.decin.apartment_predictor.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ApartmentPredictorApplication implements CommandLineRunner {

    @Autowired
    private ApartmentRepository apartmentRepository;
    @Autowired
    private ReviewRepository reviewRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApartmentPredictorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

        //testApartmentsInsert();
        //testReviewsInsert();

	}

}


