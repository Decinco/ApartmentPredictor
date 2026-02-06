package com.example.apartment_predictor.model;

public enum FurnishingStatus {
    UNFURNISHED("Unfurnished"),
    PARTIALLY_FURNISHED("Partially Furnished"),
    FULLY_FURNISHED("Fully Furnished");

    public final String literal;

    FurnishingStatus(String s) {
        literal = s;
    }

    public String getLiteral() {
        return literal;
    }
}
