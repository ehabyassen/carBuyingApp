package com.example.carBuyingApp.adapter;

import com.example.carBuyingApp.enums.InspectionCompany;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AutoCheckCoAdapter implements InspectionAdapter {

    @Override
    public InspectionCompany getCompany() {
        return InspectionCompany.AUTO_CHECK_CO;
    }

    @Override
    public void sendInspectionRequest(Long offerId, Long customerRequestId) {
        // Simulate API call to Auto Check Co
        log.info("[AutoCheckCoAdapter] Sending inspection request for offerId: {}, requestId: {}", offerId, customerRequestId);
        // Similar integration logic here
    }
}