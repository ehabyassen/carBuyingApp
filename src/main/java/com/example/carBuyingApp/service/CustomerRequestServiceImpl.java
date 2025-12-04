package com.example.carBuyingApp.service;

import com.example.carBuyingApp.dto.CustomerRequestCreateDto;
import com.example.carBuyingApp.dto.CustomerRequestResponseDto;
import com.example.carBuyingApp.dto.CustomerRequestUpdateDto;
import com.example.carBuyingApp.enums.RequestStatus;
import com.example.carBuyingApp.exception.CustomerRequestNotFoundException;
import com.example.carBuyingApp.mapper.CustomerRequestMapper;
import com.example.carBuyingApp.model.CustomerRequest;
import com.example.carBuyingApp.repository.CustomerRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerRequestServiceImpl implements CustomerRequestService {

    private final CustomerRequestRepository customerRequestRepository;
    private final CustomerRequestMapper customerRequestMapper;

    @Override
    public CustomerRequestResponseDto createCustomerRequest(CustomerRequestCreateDto customerRequestCreateDto) {
        CustomerRequest customerRequest = customerRequestMapper.fromCreateDto(customerRequestCreateDto);
        CustomerRequest savedCustomer = customerRequestRepository.save(customerRequest);
        return customerRequestMapper.toResponseDto(savedCustomer);
    }

    @Override
    public Page<CustomerRequestResponseDto> getCustomerRequestsByStatus(String status, int page, int size) {
        RequestStatus requestStatus = RequestStatus.valueOf(status);
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<CustomerRequest> customerRequests = customerRequestRepository.findByStatus(requestStatus, pageable);
        return customerRequestMapper.toDtoPage(customerRequests);
    }

    @Override
    public CustomerRequestResponseDto updateCustomerRequestStatus(Long requestId,
                                                                  CustomerRequestUpdateDto customerRequestUpdateDto) {
        CustomerRequest customerRequest = customerRequestRepository.findById(requestId)
                .orElseThrow(() -> new CustomerRequestNotFoundException(requestId));
        customerRequest.setStatus(customerRequestUpdateDto.getStatus());
        CustomerRequest updatedCustomerRequest = customerRequestRepository.save(customerRequest);
        return customerRequestMapper.toResponseDto(updatedCustomerRequest);
    }
}
