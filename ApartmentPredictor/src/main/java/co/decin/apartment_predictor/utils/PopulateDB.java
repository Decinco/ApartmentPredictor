package co.decin.apartment_predictor.utils;

import co.decin.apartment_predictor.model.*;
import co.decin.apartment_predictor.model.dto.PopulateDBRequest;
import co.decin.apartment_predictor.model.dto.PopulateDBReturn;
import co.decin.apartment_predictor.utils.populators.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PopulateDB {

    @Autowired
    PopulateApartment populateApartment;

    @Autowired
    PopulateOwner populateOwner;

    @Autowired
    PopulateReviewer populateReviewer;

    @Autowired
    PopulateReview populateReview;

    @Autowired
    PopulateContract populateContract;

    @Autowired
    PopulateSchool populateSchool;



    public PopulateDBReturn populateAll(PopulateDBRequest amounts) {
        List<Apartment> apartments = populateApartment.populateApartments(amounts.getApartments());
        List<Owner> owners = populateOwner.populateOwners(amounts.getOwners());
        List<Reviewer> reviewers = populateReviewer.populateReviewers(amounts.getReviewers());
        List<Review> reviews = populateReview.populateReviews(amounts.getReviews());
        List<Contract> contracts = populateContract.populateContracts(amounts.getContracts());
        List<School> schools = populateSchool.populateSchools(amounts.getSchools());

        return new PopulateDBReturn(apartments, contracts, owners, reviews, reviewers, schools);
    }
}
