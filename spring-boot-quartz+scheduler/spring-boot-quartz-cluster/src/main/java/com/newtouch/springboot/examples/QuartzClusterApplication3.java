package com.newtouch.springboot.examples;

import com.newtouch.springboot.examples.utils.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class QuartzClusterApplication3 {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(QuartzClusterApplication3.class, args);
        SpringContextUtil.applicationContext = applicationContext;
    }
}
