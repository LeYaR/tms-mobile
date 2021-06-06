package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dto.Call;
import com.example.callaccountingsystem.domain.dto.Status;
import com.example.callaccountingsystem.domain.dto.Subscriber;
import com.example.callaccountingsystem.domain.dto.Tower;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class GenerationService implements GenerationServiceInterface{
    private final SubscriberServiceInterface subscriberServiceInterface;
    private final TowerServiceInterface towerServiceInterface;
    private final StatusServiceInterface statusServiceInterface;
    private final CallServiceInterface callServiceInterface;

    public GenerationService(SubscriberServiceInterface subscriberServiceInterface, TowerServiceInterface towerServiceInterface, StatusServiceInterface statusServiceInterface, CallServiceInterface callServiceInterface) {
        this.subscriberServiceInterface = subscriberServiceInterface;
        this.towerServiceInterface = towerServiceInterface;
        this.statusServiceInterface = statusServiceInterface;
        this.callServiceInterface = callServiceInterface;
    }

    @Override
    public void generate() {
        List<Call> callList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            LocalDateTime date = new Timestamp(ThreadLocalRandom.current().nextLong(Timestamp.valueOf("2000-01-01 00:00:00").getTime(), Timestamp.valueOf("2021-01-01 00:00:00").getTime())).toLocalDateTime();

            List<Subscriber> subscriberList = subscriberServiceInterface.getListSubscribers();
            Subscriber incomingSubscriber = subscriberList.get(ThreadLocalRandom.current().nextInt(subscriberList.size()));
            Subscriber outgoingSubscriber = subscriberList.get(ThreadLocalRandom.current().nextInt(subscriberList.size()));

            LocalTime duration = LocalTime.of(ThreadLocalRandom.current().nextInt(24), ThreadLocalRandom.current().nextInt(60), ThreadLocalRandom.current().nextInt(60));

            List<Tower> towerList = towerServiceInterface.getListTowers();
            Tower tower = towerList.get(ThreadLocalRandom.current().nextInt(towerList.size()));

            List<Status> statusList = statusServiceInterface.getListStatuses();
            Status status = statusList.get(ThreadLocalRandom.current().nextInt(statusList.size()));

            callList.add(new Call(date, incomingSubscriber, outgoingSubscriber, duration, tower, status));
        }
        callServiceInterface.saveListCalls(callList);
    }

}
