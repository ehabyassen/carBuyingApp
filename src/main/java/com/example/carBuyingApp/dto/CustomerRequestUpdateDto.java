package com.example.carBuyingApp.dto;

import com.example.carBuyingApp.enums.RequestStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerRequestUpdateDto {

    @NotNull
    private RequestStatus status;
}