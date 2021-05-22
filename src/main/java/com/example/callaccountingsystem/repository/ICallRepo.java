package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.CallEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICallRepo extends CrudRepository<CallEntity, Long> {
}
