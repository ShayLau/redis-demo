package com.redis.demo.controller;

import com.redis.demo.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ShayLau
 */
@RestController
@RequestMapping("/get")
public class GetController {

    @Autowired
    private BaseService baseService;


    @GetMapping("")
    public void getKey(String key) {
        baseService.get(key);
    }


}
