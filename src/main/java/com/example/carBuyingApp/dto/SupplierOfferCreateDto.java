package com.example.carBuyingApp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SupplierOfferCreateDto {

    @NotNull
    private Long supplierId;

    @NotNull
    private Long requestId;

    @NotNull
    private Double price;

    @NotBlank
    private String carDetails;
}