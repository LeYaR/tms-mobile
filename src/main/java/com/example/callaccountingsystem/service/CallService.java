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

    public CallService(CallRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Call> getAllCalls() {
        final List<CallEntity> list = repository.findAll();
        return CallMapper.CALL_MAPPER.listFromDbo(list);
    }

}
