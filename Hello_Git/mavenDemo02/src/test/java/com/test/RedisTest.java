package com.test;

import com.pccc.demo.MavendemoApplication;
import com.pccc.demo.util.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author jinquanhua
 * @date 2020/5/17 17:42
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MavendemoApplication.class)
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisUtils redisUtils;
    @Test
    public void sset() {
        redisUtils.set("zz","zz");
        System.out.println(redisUtils.get("zz"));
        System.out.println(redisUtils.set("abc","cba"));
        System.out.println(redisUtils.get("aa"));
        redisTemplate.opsForValue().set("xx","100");
        System.out.println(redisTemplate.opsForValue().get("x"));
        System.out.println(redisTemplate.opsForValue().get("aa"));
        System.out.println("======");
    }

}
