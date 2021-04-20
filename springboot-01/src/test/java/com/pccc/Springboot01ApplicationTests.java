package com.pccc;

import com.pccc.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
/*
import com.pccc.demo.MavendemoApplication;
import com.pccc.demo.util.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
* */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot01ApplicationTests {
    @Autowired
    Person person;
    @Autowired
    ApplicationContext ioc;
    @Test
    public void is() {
        System.out.println(ioc.containsBean("beanService"));
    }
    @Test
    public void contextLoads() {
        System.out.println(person);
    }

}
