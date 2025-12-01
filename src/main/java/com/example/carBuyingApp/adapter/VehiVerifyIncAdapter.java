package com.example.carBuyingApp.adapter;

import com.example.carBuyingApp.enums.InspectionCompany;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class VehiVerifyIncAdapter implements InspectionAdapter {

    @Override
    public InspectionCompany getCompany() {
        return InspectionCompany.VEHI_VERIFY_INC;
    }

    @Override
    public void sendInspectionRequest(Long offerId, Long customerRequestId) {
        // Simulate API call to VEHI Verify Inc
        log.info("[VehiVerifyIncAdapter] Sending inspection request for offerId: {}, requestId: {}", offerId, customerRequestId);
        // Similar integration logic here
    }
}