package com.newtouch.springboot.examples.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class SchedulerTask {

    private int count=0;

    @Scheduled(cron="*/5 * * * * ?")
    private void process(){
        log.info("this is scheduler task runing  "+(count++));
    }

}
