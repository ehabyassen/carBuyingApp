package com.example.carBuyingApp.dto;

import com.example.carBuyingApp.enums.InspectionCompany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerRequestCreateDto {

    @NotNull
    private Long customerId;

    @NotBlank
    private String description;

    @NotNull
    private InspectionCompany checkedByCompany;
}