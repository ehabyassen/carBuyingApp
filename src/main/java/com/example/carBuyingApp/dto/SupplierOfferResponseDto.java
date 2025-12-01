package com.example.carBuyingApp.dto;

import com.example.carBuyingApp.enums.OfferStatus;
import lombok.Data;

@Data
public class SupplierOfferResponseDto {

    private Long id;
    private Long supplierId;
    private Long requestId;

    private String carDetails;
    private Double price;
    private Integer inspectionScore;

    private OfferStatus status;
    private String createdAt;
    private String updatedAt;
}