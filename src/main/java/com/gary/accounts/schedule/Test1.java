package com.gary.accounts.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Test1 extends AbstractSchedule {

    @Scheduled(cron = "0/2 * * * * ?")
    private void test1(){
        getLock();
    }


    @Override
    void doSchedule() {
    }
}
