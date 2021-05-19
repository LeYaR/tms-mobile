package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.TariffPlanEntity;
import org.springframework.data.repository.CrudRepository;

public interface ITariffPlanRepo extends CrudRepository<TariffPlanEntity, Long> {
}
