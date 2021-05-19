package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.StatusEntity;
import org.springframework.data.repository.CrudRepository;

public interface IStatusRepo extends CrudRepository<StatusEntity, Long> {
}
