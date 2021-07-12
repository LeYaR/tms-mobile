package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.MobileOperatorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MobileOperatorRepository extends JpaRepository<MobileOperatorEntity, Long> {

    Page<MobileOperatorEntity> findAll(Pageable pageable);

    Optional<MobileOperatorEntity> findFirstByCodeAndOperator(Integer code, String operator);

}
