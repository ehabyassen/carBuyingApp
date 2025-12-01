package com.example.carBuyingApp.adapter;

import com.example.carBuyingApp.enums.InspectionCompany;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class InspectionAdapterFactory {

    private final Map<InspectionCompany, InspectionAdapter> adapterMap;

    public InspectionAdapterFactory(List<InspectionAdapter> adapters) {
        this.adapterMap = adapters.stream()
                .collect(Collectors.toMap(
                        InspectionAdapter::getCompany,
                        Function.identity()
                ));
    }

    public InspectionAdapter getAdapter(InspectionCompany company) {
        return adapterMap.get(company);
    }
}
