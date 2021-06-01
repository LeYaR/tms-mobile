package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.CallEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallRepository extends JpaRepository<CallEntity, Long> {
}
