package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.CallEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CallRepository extends JpaRepository<CallEntity, Long> {

    Page<CallEntity> findAll(Pageable pageable);

    Page<CallEntity> findAllByDate_DateBetweenAndIncomingSubscriber_PhoneNumberAndOutgoingSubscriber_PhoneNumberAndStatus_StatusAndTower_Name
            (LocalDate date_date, LocalDate date_date2, Long incomingSubscriber_phoneNumber,
             Long outgoingSubscriber_phoneNumber, String status_status, String tower_name, Pageable pageable);
}
