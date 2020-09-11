package com.redis.demo.service;

/**
 * @author ShayLau
 * @date 2020/9/8 2:51 下午
 */
public interface PublishService {

    /**
     * 发布消息
     *
     * @param message 消息
     * @param channel 通道
     */
    void publishMessage(String message, String channel);
}
