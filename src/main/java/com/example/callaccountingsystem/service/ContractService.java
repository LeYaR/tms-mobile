package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.ContractEntity;
import com.example.callaccountingsystem.domain.dto.Contract;
import com.example.callaccountingsystem.domain.mapping.ContractMapper;
import com.example.callaccountingsystem.repository.ClientTypeRepository;
import com.example.callaccountingsystem.repository.ContractRepository;
import com.example.callaccountingsystem.repository.TariffPlanRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements ContractServiceInterface {

    private final ContractRepository repository;
    private final TariffPlanRepository tariffPlanRepository;
    private final ClientTypeRepository clientTypeRepository;
    private final ContractMapper mapper;

    public ContractService(ContractRepository repository,
                           TariffPlanRepository tariffPlanRepository,
                           ClientTypeRepository clientTypeRepository,
                           ContractMapper mapper) {
        this.repository = repository;
        this.tariffPlanRepository = tariffPlanRepository;
        this.clientTypeRepository = clientTypeRepository;
        this.mapper = mapper;
    }

    @Override
    public Page<Contract> getAllContracts(int currentPage, int pageSize) {
        final Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        final Page<ContractEntity> page = repository.findAll(pageable);
        return page.map(mapper::fromDbo);
    }

    @Override
    public int getQuantityPages(int pageSize) {
        return repository.findAll().size() / pageSize + 1;
    }

    @Override
    public Contract get(Long id) {
        return mapper.fromDbo(repository.findById(id).get());
    }

    @Override
    public void save(Contract contract) {
        final ContractEntity contractEntity = mapper.toDbo(contract);
        tariffPlanRepository.findFirstByName(contract.getTariffPlan().getName().trim())
                .ifPresent(contractEntity::setTariffPlan);
        clientTypeRepository.findFirstByType(contract.getClientType().getType().trim())
                .ifPresent(contractEntity::setClientType);
        repository.save(contractEntity);
    }

}
