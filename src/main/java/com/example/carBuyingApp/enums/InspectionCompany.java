package com.example.carBuyingApp.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum InspectionCompany {

    AUTO_CHECK_CO("Auto Check Co"),
    VEHI_VERIFY_INC("VEHI Verify Inc");

    private final String displayName;

    InspectionCompany(String displayName) {
        this.displayName = displayName;
    }

    @JsonValue
    public String getDisplayName() {
        return displayName;
    }
}
