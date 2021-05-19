package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.PassportEntity;
import org.springframework.data.repository.CrudRepository;

public interface IPassportRepo extends CrudRepository<PassportEntity, String> {
}
