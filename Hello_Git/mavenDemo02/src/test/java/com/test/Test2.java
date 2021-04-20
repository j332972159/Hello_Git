package com.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author jinquanhua
 * @date 2020/5/17 18:41
 */
public class Test2 {
    @Autowired private RedisTemplate redisTemplate;
    @Test
    public void tests() {
        redisTemplate.opsForValue().set("xx","x");//没有runwith和springboottest注解 跑不了springbootxiangmu Autowired注解为空
    }
}
