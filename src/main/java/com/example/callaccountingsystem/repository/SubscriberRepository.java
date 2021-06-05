package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.SubscriberEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRepository extends JpaRepository<SubscriberEntity, Long> {

    Page<SubscriberEntity> findAll(Pageable pageable);
}
