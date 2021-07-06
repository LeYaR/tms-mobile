package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.StatusEntity;
import com.example.callaccountingsystem.domain.dto.Status;
import com.example.callaccountingsystem.domain.mapping.StatusMapper;
import com.example.callaccountingsystem.exception.FieldAlreadyExistException;
import com.example.callaccountingsystem.repository.StatusRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService implements StatusServiceInterface {

    private final StatusRepository repository;
    private final StatusMapper mapper;

    public StatusService(StatusRepository repository, StatusMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Page<Status> getAllStatuses(int currentPage, int pageSize) {
        final Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        final Page<StatusEntity> page = repository.findAll(pageable);
        return page.map(mapper::fromDbo);
    }

    @Override
    public List<Integer> getAllListStatusCode() {
        return repository.findAllByCode();
    }

    @Override
    public int getQuantityPages(int pageSize) {
        return repository.findAll().size() / pageSize + 1;
    }

    @Override
    public Status get(Integer code) {
        return mapper.fromDbo(repository.findById(code).get());
    }

    @Override
    public void save(Status status) {
        if (repository.findFirstByStatus(status.getStatus().trim()).isPresent()) {
            throw new FieldAlreadyExistException("Status \"" + status.getStatus() + "\"" + " already exists!");
        }
        repository.save(mapper.toDbo(status));
    }

}
