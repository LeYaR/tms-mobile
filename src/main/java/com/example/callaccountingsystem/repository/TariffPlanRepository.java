package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.TariffPlanEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TariffPlanRepository extends JpaRepository<TariffPlanEntity, Integer> {

    Page<TariffPlanEntity> findAll(Pageable pageable);

    Optional<TariffPlanEntity> findFirstByNameAndIdIsNot(String name, Integer id);

    Optional<TariffPlanEntity> findFirstByName(String name);

}
