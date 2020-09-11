package com.redis.demo.controller;

import com.redis.demo.service.PubSubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ShayLau
 * @date 2020/9/8 1:42 下午
 */
@RequestMapping("/subscribe")
@RestController()
public class SubscribeController {

    @Autowired
    private PubSubService pubSubService;


    /**
     * 订阅频道
     *
     * @param channels 频道名称
     */
    @PostMapping("/channel")
    public void subscribeChannel(String channels) {
        pubSubService.subscribeChannel(channels.split(","));
    }


}
