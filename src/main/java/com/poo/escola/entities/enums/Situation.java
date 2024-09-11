package com.poo.escola.entities.enums;

public enum Situation {
    APPROVED("Approved!"),
    FAILED("Failed!"),
    IN_RECOVERY("In recovery");

    private final String stts;

    Situation(String stts) {
        this.stts = stts;
    }

    public String getStts() {
        return stts;
    }
}
