package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.PassportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPassportRepo extends JpaRepository<PassportEntity, String> {
}
