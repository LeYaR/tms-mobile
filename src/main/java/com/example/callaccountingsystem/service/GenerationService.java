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
public class GenerationService implements GenerationServiceInterface {

    private final SubscriberServiceInterface subscriberServiceInterface;
    private final TowerServiceInterface towerServiceInterface;
    private final StatusServiceInterface statusServiceInterface;
    private final CallServiceInterface callServiceInterface;

    public GenerationService(SubscriberServiceInterface subscriberServiceInterface,
                             TowerServiceInterface towerServiceInterface, StatusServiceInterface statusServiceInterface,
                             CallServiceInterface callServiceInterface) {
        this.subscriberServiceInterface = subscriberServiceInterface;
        this.towerServiceInterface = towerServiceInterface;
        this.statusServiceInterface = statusServiceInterface;
        this.callServiceInterface = callServiceInterface;
    }

    @Override
    public void generateMillion() {
        long start = System.currentTimeMillis();
        generate(1000000, 01, 2000, 00, 2020);
        System.out.println("Time: " + (System.currentTimeMillis() - start));
    }

    @Override
    public void generate(int quantity, int fromMonth, int fromYear, int toMonth, int toYear) {
        final List<Call> callList = new ArrayList<>();
        final List<Long> listPhoneNumber = subscriberServiceInterface.getAllPhoneNumbers();
        final List<Integer> listTowerName = towerServiceInterface.getAllListTowerId();
        final List<Integer> listStatusName = statusServiceInterface.getAllListStatusCode();
        LocalDateTime date;
        LocalTime duration;
        int listPhoneNumberSize = listPhoneNumber.size();
        int towerListSize = listTowerName.size();
        int statusListSize = listStatusName.size();
        int toYearForRandom = (toMonth == 12) ? (toYear + 1) : toYear;
        int toMonthForRandom = (toMonth == 12) ? 01 : (toMonth + 1);


        for (int i = 1; i <= quantity; i++) {
            Subscriber subscriber1 = new Subscriber();
            Subscriber subscriber2 = new Subscriber();
            Tower tower = new Tower();
            Status status = new Status();
            date = new Timestamp(ThreadLocalRandom.current().nextLong(Timestamp.valueOf(fromYear + "-" + fromMonth
                    + "-01 00:00:00").getTime(), Timestamp.valueOf(toYearForRandom + "-" + toMonthForRandom
                    + "-01 00:00:00").getTime())).toLocalDateTime();
            subscriber1.setPhoneNumber(listPhoneNumber.get(ThreadLocalRandom.current().nextInt(listPhoneNumberSize)));
            subscriber2.setPhoneNumber(listPhoneNumber.get(ThreadLocalRandom.current().nextInt(listPhoneNumberSize)));
            duration = LocalTime.of(ThreadLocalRandom.current().nextInt(24), ThreadLocalRandom.current()
                    .nextInt(60), ThreadLocalRandom.current().nextInt(60));
            tower.setId(listTowerName.get(ThreadLocalRandom.current().nextInt(towerListSize)));
            status.setCode(listStatusName.get(ThreadLocalRandom.current().nextInt(statusListSize)));

            callList.add(new Call(date, subscriber1, subscriber2, duration, tower, status));
        }
        callServiceInterface.saveListCalls(callList);
    }

}
