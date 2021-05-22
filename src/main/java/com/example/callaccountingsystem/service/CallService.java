package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.CallEntity;
import com.example.callaccountingsystem.domain.dto.Call;
import com.example.callaccountingsystem.domain.mapping.CallMapper;
import com.example.callaccountingsystem.repository.ICallRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CallService {

    private final ICallRepo repository;
    private final CallMapper mapper;

    public CallService(ICallRepo repository, CallMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Call> getAllCalls() {
        final Iterable<CallEntity> list = repository.findAll();
        List<Call> calls = new ArrayList<>();
        list.forEach((callEntity -> calls.add(mapper.fromDbo(callEntity))));
        return calls;
    }
}
