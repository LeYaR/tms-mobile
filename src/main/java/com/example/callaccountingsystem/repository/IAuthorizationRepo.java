package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dto.Authorization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorizationRepo extends CrudRepository<Authorization, String> {
}
