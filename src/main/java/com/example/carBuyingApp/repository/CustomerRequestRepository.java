package com.example.carBuyingApp.repository;

import com.example.carBuyingApp.enums.RequestStatus;
import com.example.carBuyingApp.model.CustomerRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRequestRepository extends JpaRepository<CustomerRequest, Long> {

    Page<CustomerRequest> findByStatus(RequestStatus status, Pageable pageable);
}
