package com.example.carBuyingApp.exception;

public class CustomerRequestNotFoundException extends RuntimeException {

    public CustomerRequestNotFoundException(Long requestId) {
        super("Customer request with id %d not found.".formatted(requestId));
    }
}
