package com.example.carBuyingApp.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum RequestStatus {

    ACTIVE("Active"),
    CLOSED("Closed"),
    CANCELLED("Cancelled");

    private final String displayName;

    RequestStatus(String displayName) {
        this.displayName = displayName;
    }

    @JsonValue
    public String getDisplayName() {
        return displayName;
    }
}
