package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.CallEntity;
import com.example.callaccountingsystem.domain.dto.Call;
import com.example.callaccountingsystem.domain.mapping.CallMapper;
import com.example.callaccountingsystem.repository.CallRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CallService implements CallServiceInterface {

    private final CallRepository repository;
    private final CallMapper mapper;

    public CallService(CallRepository repository, CallMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Call> getAllCalls() {
        final List<CallEntity> list = repository.findAll();
        return mapper.listFromDbo(list);
    }

}
