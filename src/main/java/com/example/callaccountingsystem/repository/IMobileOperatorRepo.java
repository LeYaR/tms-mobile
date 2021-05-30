package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.MobileOperatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMobileOperatorRepo extends JpaRepository<MobileOperatorEntity, Long> {
}
