package com.newtouch.springboot.tomcat.examples;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ServletConfig {
    @Bean
    ServletRegistrationBean<ServletDemo> servletDemo() {
        ServletRegistrationBean<ServletDemo> servlet = new ServletRegistrationBean<ServletDemo>();
        servlet.addUrlMappings("/hello");
        servlet.setServlet(new ServletDemo());
        return servlet;
    }
}
