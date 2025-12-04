package com.example.carBuyingApp.advice;

import com.example.carBuyingApp.exception.CustomerRequestNotFoundException;
import com.example.carBuyingApp.exception.InspectionAdapterNotFoundException;
import com.example.carBuyingApp.exception.OfferSubmissionNotAllowedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Collections;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private ResponseEntity<ErrorResponse> buildError(HttpStatus status, String message) {
        ErrorResponse error = new ErrorResponse(
                status.value(),
                status.getReasonPhrase(),
                Collections.singletonList(message),
                LocalDateTime.now()
        );
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(CustomerRequestNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCustomerRequestNotFoundException(CustomerRequestNotFoundException ex) {
        return buildError(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(OfferSubmissionNotAllowedException.class)
    public ResponseEntity<ErrorResponse> handleOfferSubmissionNotAllowedException(OfferSubmissionNotAllowedException ex) {
        return buildError(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(InspectionAdapterNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleInspectionAdapterNotFoundException(InspectionAdapterNotFoundException ex) {
        return buildError(HttpStatus.NOT_IMPLEMENTED, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        return buildError(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Error: " + ex.getMessage());
    }
}
