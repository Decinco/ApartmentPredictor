package com.example.apartment_predictor.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum FurnishingStatus {
    UNFURNISHED("Unfurnished"),
    PARTIALLY_FURNISHED("Partially Furnished"),
    FULLY_FURNISHED("Fully Furnished");

    public final String literal;

    FurnishingStatus(String s) {
        literal = s;
    }

    @JsonValue
    public String getLiteral() {
        return literal;
    }
}
