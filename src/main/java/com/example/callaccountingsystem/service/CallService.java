package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.CallEntity;
import com.example.callaccountingsystem.domain.dto.Call;
import com.example.callaccountingsystem.domain.mapping.CallMapper;
import com.example.callaccountingsystem.repository.CallRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CallService implements CallServiceInterface {

    private final CallRepository repository;
    private final CallMapper mapper;

    public CallService(CallRepository repository, CallMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Page<Call> getAllCalls(int currentPage, int pageSize) {
        final Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        final Page<CallEntity> page = repository.findAll(pageable);
        return page.map(callEntity -> (mapper.fromDbo(callEntity)));
    }

}
