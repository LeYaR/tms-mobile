package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatusRepo extends JpaRepository<StatusEntity, Long> {
}
