package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dto.Subscriber;
import org.springframework.data.domain.Page;

public interface SubscriberServiceInterface {

    Page<Subscriber> getAllSubscribers(int currentPage, int pageSize);

}
