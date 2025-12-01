package com.example.carBuyingApp.controller;

import com.example.carBuyingApp.dto.SupplierOfferCreateDto;
import com.example.carBuyingApp.dto.SupplierOfferResponseDto;
import com.example.carBuyingApp.service.SupplierOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offers")
@RequiredArgsConstructor
public class SupplierOfferController {

    private final SupplierOfferService supplierOfferService;

    @PostMapping
    public ResponseEntity<SupplierOfferResponseDto> submitOffer(@RequestBody SupplierOfferCreateDto createDto) {
        return ResponseEntity.ok(supplierOfferService.submitOffer(createDto));
    }

    @GetMapping("/by-request/{requestId}")
    public ResponseEntity<List<SupplierOfferResponseDto>> getOffersByRequestId(@PathVariable Long requestId) {
        return ResponseEntity.ok(supplierOfferService.getOffersByRequestId(requestId));
    }

    @GetMapping("/by-supplier/{supplierId}")
    public ResponseEntity<List<SupplierOfferResponseDto>> getOffersBySupplierId(@PathVariable Long supplierId) {
        return ResponseEntity.ok(supplierOfferService.getOffersBySupplierId(supplierId));
    }
}
