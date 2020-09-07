package com.redis.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author ShayLau
 * @date 2020/9/7 3:36 下午
 */
@Service
@Slf4j
public class LockServiceImpl implements LockService {

    @Autowired
    private RedissonClient client;

    @Override
    public void getLock(String key) {
        RLock lock = client.getLock(key);
        lock.lock(10, TimeUnit.MINUTES);
        log.info("lock.isLocked():" + lock.isLocked());
    }
}
