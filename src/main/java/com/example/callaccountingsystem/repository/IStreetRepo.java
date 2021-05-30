package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.StreetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStreetRepo extends JpaRepository<StreetEntity, Long> {
}
