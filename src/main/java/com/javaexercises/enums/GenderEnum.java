package com.javaexercises.enums;

public enum GenderEnum {
    MALE("Male"),
    FEMALE("Female");

    private final String label;

    public String getLabel() {
        return label;
    }

    GenderEnum(String label) {
        this.label = label;
    }
}
