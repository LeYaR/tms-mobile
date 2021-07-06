package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.MobileOperatorEntity;
import com.example.callaccountingsystem.domain.dto.MobileOperator;
import com.example.callaccountingsystem.domain.mapping.MobileOperatorMapper;
import com.example.callaccountingsystem.exception.FieldAlreadyExistException;
import com.example.callaccountingsystem.repository.MobileOperatorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MobileOperatorService implements MobileOperatorServiceInterface {
    private final MobileOperatorRepository repository;
    private final MobileOperatorMapper mapper;

    public MobileOperatorService(MobileOperatorRepository repository, MobileOperatorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Page<MobileOperator> getAllMobileOperators(int currentPage, int pageSize) {
        final Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        final Page<MobileOperatorEntity> page = repository.findAll(pageable);
        return page.map(mapper::fromDbo);
    }

    @Override
    public int getQuantityPages(int pageSize) {
        return repository.findAll().size() / pageSize + 1;
    }

    @Override
    public MobileOperator get(Long id) {
        return mapper.fromDbo(repository.findById(id).get());
    }

    @Override
    public void save(MobileOperator mobileOperator) {
        if (repository.findFirstByCodeAndOperator(mobileOperator.getCode(),
                mobileOperator.getOperator().trim()).isPresent()) {
            throw new FieldAlreadyExistException("Mobile operator \""
                    + mobileOperator.getOperator() + "(code " + mobileOperator.getCode() + ")\" already exists!");
        }
        repository.save(mapper.toDbo(mobileOperator));
    }

}
