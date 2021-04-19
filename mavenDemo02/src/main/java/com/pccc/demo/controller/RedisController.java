package com.pccc.demo.controller;

import com.pccc.demo.util.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author jinquanhua
 * @date 2020/5/17 12:46
 */
@RestController
public class RedisController {
    Logger logger = LoggerFactory.getLogger(RedisController.class);
    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("/testRedis")
    public String testRedis(){
        String id="1";
        //查询redis缓存中是否存在
        boolean exists = redisUtils.exists(id);
        if(exists){
            //获取缓存
            Object obj = redisUtils.get(id);
            System.out.println("从缓存中获取的数据："+obj.toString());
            return obj.toString();
        }else{
            System.out.println("模拟去mysql获取数据");
            String list="test data!";
            //数据插入缓存
            //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
            redisUtils.set(id,list,10L, TimeUnit.MINUTES);
            System.out.println("数据已存入redis");
            return list;
        }
    }


}
