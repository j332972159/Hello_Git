package com.newtouch.springboot.examples.utils;

import org.springframework.context.ApplicationContext;

public class SpringContextUtil {
    public static ApplicationContext applicationContext;

    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }
}