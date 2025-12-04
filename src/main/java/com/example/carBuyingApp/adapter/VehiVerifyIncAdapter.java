package com.example.carBuyingApp.adapter;

import com.example.carBuyingApp.enums.InspectionCompany;
import com.example.carBuyingApp.model.SupplierOffer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Component
public class VehiVerifyIncAdapter implements InspectionAdapter {

    @Override
    public InspectionCompany getCompany() {
        return InspectionCompany.VEHI_VERIFY_INC;
    }

    @Override
    public Integer getInspectionScore(SupplierOffer supplierOffer) {
        // Simulate API call to VEHI Verify Inc
        log.info("[VehiVerifyIncAdapter] Sending inspection request for offer: {}", supplierOffer);
        // Simulate integration logic here
        return ThreadLocalRandom.current().nextInt(1, 101);
    }
}