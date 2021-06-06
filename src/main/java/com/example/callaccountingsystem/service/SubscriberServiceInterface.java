package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dto.Subscriber;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SubscriberServiceInterface {

    Page<Subscriber> getAllSubscribers(int currentPage, int pageSize);

    List<Subscriber> getListSubscribers();
}
