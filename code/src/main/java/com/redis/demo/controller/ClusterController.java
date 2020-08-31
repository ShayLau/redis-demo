package com.redis.demo.controller;

import com.redis.demo.service.cache.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: ShayLau
 * @Date: 2020/8/31 15:52
 */
@RestController
@RequestMapping("/cluster")
@Slf4j
public class ClusterController {


    @Autowired
    private BaseService baseService;


    /**
     * 设置数据到集群
     *
     * @param key   数据键
     * @param value 数据值
     */
    @PostMapping("")
    public void set(@RequestParam String key, @RequestParam Object value) {
        baseService.set(key, value);
    }


    /**
     * 获取集群中的key数据
     *
     * @param key 数据键
     */
    @GetMapping("")
    public void get(@RequestParam String key) {
        log.info("redis cluster set get key " + key + ",value：" + baseService.get(key));
    }

}
