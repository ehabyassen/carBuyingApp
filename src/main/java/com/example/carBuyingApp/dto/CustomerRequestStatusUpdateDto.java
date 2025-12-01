package com.example.carBuyingApp.dto;

import com.example.carBuyingApp.enums.RequestStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerRequestStatusUpdateDto {

    @NotNull
    private Long requestId;

    @NotNull
    private RequestStatus status;
}