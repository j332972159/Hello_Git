package com.newtouch.admin.client.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ClientBootstrapApplication {
    public static void main(String[] vargs) {
        SpringApplication.run(ClientBootstrapApplication.class, vargs);
    }
}
