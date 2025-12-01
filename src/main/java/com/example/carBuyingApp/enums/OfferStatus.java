package com.example.carBuyingApp.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OfferStatus {

    PENDING("Pending"),
    ACCEPTED("Accepted"),
    REJECTED("Rejected");

    private final String displayName;

    OfferStatus(String displayName) {
        this.displayName = displayName;
    }

    @JsonValue
    public String getDisplayName() {
        return displayName;
    }
}
