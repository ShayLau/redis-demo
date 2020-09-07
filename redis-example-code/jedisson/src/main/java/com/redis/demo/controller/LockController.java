package com.redis.demo.controller;

import com.redis.demo.service.LockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ShayLau
 * @date 2020/9/7 4:34 下午
 */
@RestController
@RequestMapping("/lock")
public class LockController {

    @Autowired
    private LockService lockService;


    @PostMapping("")
    public void lock(String key) {
        lockService.getLock(key);
    }


}
