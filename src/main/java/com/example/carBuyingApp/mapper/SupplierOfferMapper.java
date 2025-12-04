package com.example.carBuyingApp.mapper;

import com.example.carBuyingApp.dto.SupplierOfferCreateDto;
import com.example.carBuyingApp.dto.SupplierOfferResponseDto;
import com.example.carBuyingApp.model.SupplierOffer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupplierOfferMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "customerRequest", ignore = true)  // will be set in service
    @Mapping(target = "status", expression = "java(com.example.carBuyingApp.enums.OfferStatus.PENDING)")
    @Mapping(target = "inspectionScore", ignore = true) // inspection happens in service
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    SupplierOffer fromCreateDto(SupplierOfferCreateDto dto);

    @Mapping(target = "requestId", source = "customerRequest.id")
    @Mapping(
            target = "createdAt",
            expression = "java(entity.getCreatedAt() == null ? null : entity.getCreatedAt().toString())"
    )
    @Mapping(
            target = "updatedAt",
            expression = "java(entity.getUpdatedAt() == null ? null : entity.getUpdatedAt().toString())"
    )
    SupplierOfferResponseDto toResponseDto(SupplierOffer entity);
}
