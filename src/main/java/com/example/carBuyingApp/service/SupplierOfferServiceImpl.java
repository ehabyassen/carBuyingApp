package com.example.carBuyingApp.service;

import com.example.carBuyingApp.adapter.InspectionAdapter;
import com.example.carBuyingApp.adapter.InspectionAdapterFactory;
import com.example.carBuyingApp.dto.SupplierOfferCreateDto;
import com.example.carBuyingApp.dto.SupplierOfferResponseDto;
import com.example.carBuyingApp.enums.InspectionCompany;
import com.example.carBuyingApp.enums.RequestStatus;
import com.example.carBuyingApp.exception.CustomerRequestNotFoundException;
import com.example.carBuyingApp.exception.InspectionAdapterNotFoundException;
import com.example.carBuyingApp.exception.OfferSubmissionNotAllowedException;
import com.example.carBuyingApp.mapper.SupplierOfferMapper;
import com.example.carBuyingApp.model.CustomerRequest;
import com.example.carBuyingApp.model.SupplierOffer;
import com.example.carBuyingApp.repository.CustomerRequestRepository;
import com.example.carBuyingApp.repository.SupplierOfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SupplierOfferServiceImpl implements SupplierOfferService {

    private final SupplierOfferRepository supplierOfferRepository;
    private final CustomerRequestRepository customerRequestRepository;
    private final SupplierOfferMapper supplierOfferMapper;
    private final InspectionAdapterFactory adapterFactory;

    @Override
    public SupplierOfferResponseDto submitOffer(SupplierOfferCreateDto supplierOfferCreateDto) {
        Long requestId = supplierOfferCreateDto.getRequestId();
        CustomerRequest customerRequest = customerRequestRepository.findById(requestId)
                .orElseThrow(() -> new CustomerRequestNotFoundException(requestId));
        RequestStatus requestStatus = customerRequest.getStatus();
        if (!requestStatus.equals(RequestStatus.ACTIVE)) {
            throw new OfferSubmissionNotAllowedException(requestId, requestStatus);
        }
        SupplierOffer supplierOffer = supplierOfferMapper.fromCreateDto(supplierOfferCreateDto);
        supplierOffer.setCustomerRequest(customerRequest);
        Integer inspectionScore = getInspectionScore(supplierOffer, customerRequest);
        supplierOffer.setInspectionScore(inspectionScore);
        SupplierOffer savedSupplierOffer = supplierOfferRepository.save(supplierOffer);
        return supplierOfferMapper.toResponseDto(savedSupplierOffer);
    }

    @Override
    public List<SupplierOfferResponseDto> getOffersByRequestId(Long requestId) {
        CustomerRequest customerRequest = customerRequestRepository.findById(requestId)
                .orElseThrow(() -> new CustomerRequestNotFoundException(requestId));
        return customerRequest.getOffers()
                .stream()
                .map(supplierOfferMapper::toResponseDto)
                .toList();
    }

    @Override
    public List<SupplierOfferResponseDto> getOffersBySupplierId(Long supplierId) {
        return supplierOfferRepository.findBySupplierId(supplierId)
                .stream()
                .map(supplierOfferMapper::toResponseDto)
                .toList();
    }

    private Integer getInspectionScore(SupplierOffer supplierOffer, CustomerRequest customerRequest) {
        InspectionCompany company = customerRequest.getCheckedByCompany();
        InspectionAdapter adapter = adapterFactory.getAdapter(company);
        if (adapter == null) {
            throw new InspectionAdapterNotFoundException(company.getDisplayName());
        }
        return adapter.getInspectionScore(supplierOffer);
    }
}
