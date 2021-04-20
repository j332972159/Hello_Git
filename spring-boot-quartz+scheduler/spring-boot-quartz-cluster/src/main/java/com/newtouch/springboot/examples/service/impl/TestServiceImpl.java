package com.newtouch.springboot.examples.service.impl;

import com.newtouch.springboot.examples.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service("testServiceImpl")
public class TestServiceImpl implements TestService {

    private final Random random = new Random();

    public void run(String id) throws Exception {
        log.info("Running job on worker, job id " + id);
        if (random.nextInt(3) == 1) {
            throw new Exception("Randomly generated test exception on worker");
        }
        try {
            Thread.sleep(TimeUnit.MINUTES.toMillis(1));
        } catch (InterruptedException e) {
            log.error("Error", e);
        }
        log.info("Completed job on worker, job id " + id);
    }
}
