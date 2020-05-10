package com.gary.accounts.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Test2 extends AbstractSchedule {

    @Scheduled(cron = "0/8 * * * * ?")
    private void test2(){
        getLock();
    }

    @Override
    void doSchedule() {
    }
}
