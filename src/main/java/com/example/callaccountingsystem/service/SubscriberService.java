package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.SubscriberEntity;
import com.example.callaccountingsystem.exception.UserAlreadyExistException;
import com.example.callaccountingsystem.repository.ISubscriberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriberService {

    @Autowired
    private ISubscriberRepo subscriberRepo;

    public SubscriberEntity registration (SubscriberEntity subscriberEntity) throws UserAlreadyExistException {
        if (subscriberRepo.findByPhoneNumber(subscriberEntity.getPhoneNumber()) != null){
            throw new UserAlreadyExistException("Пользователь с таким номером уже существует");
        }
        return subscriberRepo.save(subscriberEntity);
    }
}
