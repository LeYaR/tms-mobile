package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.SubscriberEntity;
import org.springframework.data.repository.CrudRepository;

public interface ISubscriberRepo extends CrudRepository<SubscriberEntity, Long> {
    SubscriberEntity findByPhoneNumber (Integer phoneNumber);
}
