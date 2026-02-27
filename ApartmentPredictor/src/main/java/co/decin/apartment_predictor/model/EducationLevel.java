package co.decin.apartment_predictor.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EducationLevel {
    SPANISH_ELEMENTARY("Primaria"),
    SPANISH_MIDDLE("ESO"),
    SPANISH_HIGH("Bachillerato"),
    SPANISH_VOCATIONAL_MIDDLE("CFGM"),
    SPANISH_VOCATIONAL_HIGH("CFGS"),
    UNIVERSITY("University"),
    OTHER("Other");


    public final String literal;

    EducationLevel(String s) {
        literal = s;
    }

    @JsonValue
    public String getLiteral() {
        return literal;
    }
}
