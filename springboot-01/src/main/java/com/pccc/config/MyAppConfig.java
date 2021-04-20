package com.pccc.config;

import com.pccc.controller.HelloController;
import com.pccc.service.BeanService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author jinquanhua
 * @date 2020/6/5 17:57
 */
@Configuration
public class MyAppConfig {
    @Bean
    public BeanService beanService(){
        return new BeanService();
    }
}
