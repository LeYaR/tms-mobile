package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.StatusEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<StatusEntity, Integer> {

    Page<StatusEntity> findAll(Pageable pageable);

    @Query("SELECT s.code FROM StatusEntity s")
    List<Integer> findAllByCode();
}
