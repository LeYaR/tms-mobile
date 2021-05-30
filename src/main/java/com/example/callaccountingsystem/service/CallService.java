package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.CallEntity;
import com.example.callaccountingsystem.domain.dto.Call;
import com.example.callaccountingsystem.domain.mapping.CallMapper;
import com.example.callaccountingsystem.repository.ICallRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CallService implements ICallService {

    private final ICallRepo repository;

    public CallService(ICallRepo repository) {
        this.repository = repository;
    }

    @Override
    public List<Call> getAllCalls() {
        final List<CallEntity> list = repository.findAll();
        return CallMapper.CALL_MAPPER.listFromDbo(list);
    }

}
