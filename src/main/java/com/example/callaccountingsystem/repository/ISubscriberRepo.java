package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.SubscriberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubscriberRepo extends JpaRepository<SubscriberEntity, Long> {
}
