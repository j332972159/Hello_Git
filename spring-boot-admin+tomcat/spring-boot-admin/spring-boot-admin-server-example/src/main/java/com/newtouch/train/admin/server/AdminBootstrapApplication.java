package com.newtouch.train.admin.server;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class AdminBootstrapApplication {
    public static void main(String[] vargs) {
        SpringApplication.run(AdminBootstrapApplication.class, vargs);
    }
}
