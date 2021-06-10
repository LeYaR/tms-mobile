package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dto.PricingUnit;
import org.springframework.data.domain.Page;

public interface PricingUnitServiceInterface {

    Page<PricingUnit> getAllPricingUnits(int currentPage, int pageSize);

    PricingUnit get(Integer id);

    void save(PricingUnit pricingUnit);

}
