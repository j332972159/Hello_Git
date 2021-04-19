package com.pccc.demo.util.lock;

import org.springframework.data.redis.core.TimeoutUtils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author jinquanhua
 * @date 2021/4/14 13:32
 */
public class LockDemo {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

    }
}
