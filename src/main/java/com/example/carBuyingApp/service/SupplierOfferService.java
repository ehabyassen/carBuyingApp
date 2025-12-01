package com.example.carBuyingApp.service;

import com.example.carBuyingApp.dto.SupplierOfferCreateDto;
import com.example.carBuyingApp.dto.SupplierOfferResponseDto;

import java.util.List;

public interface SupplierOfferService {

    SupplierOfferResponseDto submitOffer(SupplierOfferCreateDto supplierOfferCreateDto);

    List<SupplierOfferResponseDto> getOffersByRequestId(Long requestId);

    List<SupplierOfferResponseDto> getOffersBySupplierId(Long supplierId);
}
