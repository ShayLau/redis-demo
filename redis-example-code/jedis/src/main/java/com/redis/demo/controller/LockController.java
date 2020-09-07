package com.redis.demo.controller;

import com.redis.demo.service.DistributedService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Lock
 *
 * @author ShayLau
 */
@RestController
@RequestMapping("/lock")
@Slf4j
public class LockController {

    @Autowired
    private DistributedService distributedService;

    private final String lockKey = "demoKey";

    @GetMapping("")
    public void lockKey() {
        String requestId = UUID.randomUUID().toString();
        log.info("redis distributed lock requestId:" + requestId);
        int expireTime = 1000 * 3 * 60;
        System.out.println("lock result:" + distributedService.trySetKeyLock(lockKey, requestId, expireTime));
    }

    @PostMapping("unlock")
    public void unLockKey(String requestId) {
        System.out.println("unlock reslult:" + distributedService.unLock(lockKey, requestId));
    }
}
