package com.pccc.springboot;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.math.BigDecimal;
import java.util.StringTokenizer;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootConfigApplicationTests {
    Logger logger = LoggerFactory.getLogger(SpringBootConfigApplicationTests.class);
    private BigDecimal aa = new BigDecimal(12);
   @Test
    public void file(){

    File f = new File("D:\\a.txt");
    File f1 = new File("E:\\a.txt");
    f.renameTo(f1);
    }

    @Test
    void stringToken(){
        StringTokenizer stringTokenizer = new StringTokenizer("abc",",");
        int i = stringTokenizer.countTokens();
        System.out.println(i);
        System.out.println(String.valueOf(stringTokenizer));
    }

    @Test
    void doubleTest(){
        String double1 = Double.toString(123L);
    }

    @Test
    void contextLoads() {
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }

}
