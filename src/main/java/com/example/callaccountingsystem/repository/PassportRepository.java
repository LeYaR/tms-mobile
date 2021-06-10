package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.PassportEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepository extends JpaRepository<PassportEntity, String> {

    Page<PassportEntity> findAll(Pageable pageable);
}
