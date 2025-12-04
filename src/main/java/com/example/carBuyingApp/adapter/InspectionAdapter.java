package com.example.carBuyingApp.adapter;

import com.example.carBuyingApp.enums.InspectionCompany;
import com.example.carBuyingApp.model.SupplierOffer;

public interface InspectionAdapter {

    InspectionCompany getCompany();

    Integer getInspectionScore(SupplierOffer supplierOffer);
}