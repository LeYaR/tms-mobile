package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.StatusEntity;
import com.example.callaccountingsystem.domain.dto.Status;
import com.example.callaccountingsystem.domain.mapping.StatusMapper;
import com.example.callaccountingsystem.repository.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService implements StatusServiceInterface {
    private final StatusRepository repository;

    public StatusService(StatusRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Status> getAllStatuses() {
        final List<StatusEntity> list = repository.findAll();
        return StatusMapper.STATUS_MAPPER.listFromDbo(list);
    }

}
