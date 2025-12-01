package com.example.carBuyingApp.repository;

import com.example.carBuyingApp.model.SupplierOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierOfferRepository extends JpaRepository<SupplierOffer, Long> {

    List<SupplierOffer> findBySupplierId(Long supplierId);
}
