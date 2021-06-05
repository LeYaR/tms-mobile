package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.StatusEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<StatusEntity, Long> {

    Page<StatusEntity> findAll(Pageable pageable);
}
