package com.example.carBuyingApp.dto;

import com.example.carBuyingApp.enums.InspectionCompany;
import com.example.carBuyingApp.enums.RequestStatus;
import lombok.Data;

@Data
public class CustomerRequestResponseDto {

    private Long id;
    private Long customerId;
    private String description;
    private RequestStatus status;
    private InspectionCompany checkedByCompany;

    private int offersCount;

    private String createdAt;
    private String updatedAt;
}