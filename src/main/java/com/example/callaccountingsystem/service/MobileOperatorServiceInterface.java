package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dto.MobileOperator;
import org.springframework.data.domain.Page;

public interface MobileOperatorServiceInterface {

    Page<MobileOperator> getAllMobileOperators(int currentPage, int pageSize);

    MobileOperator get(Long id);

    void save(MobileOperator mobileOperator);

}
