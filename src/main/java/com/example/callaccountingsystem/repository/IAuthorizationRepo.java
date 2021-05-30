package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.AuthorizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorizationRepo extends JpaRepository<AuthorizationEntity, String> {
}
