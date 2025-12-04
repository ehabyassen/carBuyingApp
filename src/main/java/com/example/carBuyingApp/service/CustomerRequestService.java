package com.example.carBuyingApp.service;

import com.example.carBuyingApp.dto.CustomerRequestCreateDto;
import com.example.carBuyingApp.dto.CustomerRequestResponseDto;
import com.example.carBuyingApp.dto.CustomerRequestUpdateDto;
import org.springframework.data.domain.Page;

public interface CustomerRequestService {

    CustomerRequestResponseDto createCustomerRequest(CustomerRequestCreateDto customerRequestCreateDto);

    Page<CustomerRequestResponseDto> getCustomerRequestsByStatus(String status, int page, int size);

    CustomerRequestResponseDto updateCustomerRequestStatus(Long requestId, CustomerRequestUpdateDto customerRequestUpdateDto);
}
