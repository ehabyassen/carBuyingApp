package com.example.carBuyingApp.service;

import com.example.carBuyingApp.dto.CustomerRequestCreateDto;
import com.example.carBuyingApp.dto.CustomerRequestResponseDto;
import com.example.carBuyingApp.dto.CustomerRequestStatusUpdateDto;
import com.example.carBuyingApp.enums.RequestStatus;
import org.springframework.data.domain.Page;

public interface CustomerRequestService {

    CustomerRequestResponseDto createCustomerRequest(CustomerRequestCreateDto customerRequestCreateDto);

    Page<CustomerRequestResponseDto> getCustomerRequestsByStatus(RequestStatus status, int page, int size);

    CustomerRequestResponseDto updateCustomerRequestStatus(CustomerRequestStatusUpdateDto customerRequestStatusUpdateDto);
}
