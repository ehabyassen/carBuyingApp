package com.example.carBuyingApp.exception;

public class InspectionAdapterNotFoundException extends RuntimeException {

    public InspectionAdapterNotFoundException(String company) {
        super("No inspection adapter found for company: %s".formatted(company));
    }
}
