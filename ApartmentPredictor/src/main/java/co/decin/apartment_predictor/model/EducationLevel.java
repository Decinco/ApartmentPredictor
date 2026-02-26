package co.decin.apartment_predictor.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EducationLevel {
    SPANISH_ELEMENTARY("Primaria"),
    SPANISH_MIDDLE("ESO"),
    SPANISH_HIGH("Bachillerato"),
    VOCATIONAL_INITIAL("FPI"),
    VOCATIONAL_MIDDLE("CFGM"),
    VOCATIONAL_HIGH("CFGS"),
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
