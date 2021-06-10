package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dto.TariffPlan;
import org.springframework.data.domain.Page;

public interface TariffPlanServiceInterface {

    Page<TariffPlan> getAllTariffPlans(int currentPage, int pageSize);

    TariffPlan get(Integer id);

    void save(TariffPlan tariffPlan);

}
