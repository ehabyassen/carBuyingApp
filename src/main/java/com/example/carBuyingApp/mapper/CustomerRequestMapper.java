package com.example.carBuyingApp.mapper;

import com.example.carBuyingApp.dto.CustomerRequestCreateDto;
import com.example.carBuyingApp.dto.CustomerRequestResponseDto;
import com.example.carBuyingApp.model.CustomerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface CustomerRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", expression = "java(com.example.carBuyingApp.enums.RequestStatus.ACTIVE)")
    @Mapping(target = "offers", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    CustomerRequest fromCreateDto(CustomerRequestCreateDto dto);

    @Mapping(target = "offersCount", expression = "java(entity.getOffers() == null ? 0 : entity.getOffers().size())")
    @Mapping(target = "createdAt", expression = "java(entity.getCreatedAt().toString())")
    @Mapping(target = "updatedAt", expression = "java(entity.getUpdatedAt().toString())")
    CustomerRequestResponseDto toResponseDto(CustomerRequest entity);

    default Page<CustomerRequestResponseDto> toDtoPage(Page<CustomerRequest> page) {
        return page.map(this::toResponseDto);
    }
}
