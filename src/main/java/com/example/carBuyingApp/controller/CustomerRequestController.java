package com.example.carBuyingApp.controller;

import com.example.carBuyingApp.dto.CustomerRequestCreateDto;
import com.example.carBuyingApp.dto.CustomerRequestResponseDto;
import com.example.carBuyingApp.dto.CustomerRequestStatusUpdateDto;
import com.example.carBuyingApp.enums.RequestStatus;
import com.example.carBuyingApp.service.CustomerRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/requests")
@RequiredArgsConstructor
public class CustomerRequestController {

    private final CustomerRequestService customerRequestService;

    @PostMapping
    public ResponseEntity<CustomerRequestResponseDto> createRequest(@RequestBody CustomerRequestCreateDto createDto) {
        return ResponseEntity.ok(customerRequestService.createCustomerRequest(createDto));
    }

    @GetMapping
    public ResponseEntity<Page<CustomerRequestResponseDto>> listRequestsByStatus(@RequestParam String status,
                                                                                 @RequestParam int page,
                                                                                 @RequestParam int size) {
        RequestStatus requestStatus = RequestStatus.valueOf(status);
        return ResponseEntity.ok(customerRequestService.getCustomerRequestsByStatus(requestStatus, page, size));
    }

    @PutMapping
    public ResponseEntity<CustomerRequestResponseDto> updateRequestStatus(@RequestBody CustomerRequestStatusUpdateDto statusUpdateDto) {
        return ResponseEntity.ok(customerRequestService.updateCustomerRequestStatus(statusUpdateDto));
    }
}
