package com.example.carBuyingApp.exception;

import com.example.carBuyingApp.enums.RequestStatus;

public class OfferSubmissionNotAllowedException extends RuntimeException {

    public OfferSubmissionNotAllowedException(Long requestId, RequestStatus status) {
        super("Offer submission not allowed for request %d. Current status: %s"
                .formatted(requestId, status));
    }
}
