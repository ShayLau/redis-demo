package com.redis.demo.controller;

import com.redis.demo.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ShayLau
 * @date 2020/9/8 2:58 下午
 */
@RequestMapping("/publish")
@RestController()
public class PublishController {


    @Autowired
    private PublishService publishService;


    /**
     * 发送消息
     *
     * @param channel 通道
     * @param message 消息
     */
    @PostMapping("")
    public void publishMessage(String channel, String message) {
        publishService.publishMessage(channel, message);
    }

}
