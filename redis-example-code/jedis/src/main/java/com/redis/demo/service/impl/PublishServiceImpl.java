package com.redis.demo.service.impl;

import com.redis.demo.service.PublishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @author ShayLau
 * @date 2020/9/8 2:53 下午
 */
@Service
@Slf4j
public class PublishServiceImpl implements PublishService {

    @Autowired
    private Jedis jedis;

    /**
     * 发布消息
     *
     * @param message 消息
     * @param channel 通道
     */
    @Override
    public void publishMessage(String channel, String message) {
        jedis.publish(channel, message);

        Transaction transaction = jedis.multi();
    }
}
