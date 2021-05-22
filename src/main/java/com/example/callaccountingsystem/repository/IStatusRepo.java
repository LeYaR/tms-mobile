package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.StatusEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatusRepo extends CrudRepository<StatusEntity, Long> {
}
