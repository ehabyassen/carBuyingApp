package com.example.carBuyingApp.adapter;

import com.example.carBuyingApp.enums.InspectionCompany;

public interface InspectionAdapter {

    InspectionCompany getCompany();

    void sendInspectionRequest(Long offerId, Long customerRequestId);
}