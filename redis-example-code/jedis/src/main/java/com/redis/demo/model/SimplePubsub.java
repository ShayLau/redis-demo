package com.redis.demo.model;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.JedisPubSub;

/**
 * 简单消息订阅
 *
 * @author ShayLau
 * @date 2020/9/8 1:46 下午
 */
@Slf4j
public class SimplePubsub extends JedisPubSub {


    @Override
    public void onMessage(String channel, String message) {
        super.onMessage(channel, message);
        log.info("Channel:{},message:{}", channel, message);
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {
        super.onPMessage(pattern, channel, message);
        log.info("pattern:{},channel:{},message:{2}", pattern, channel, message);

    }

    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        super.onPSubscribe(pattern, subscribedChannels);
        log.info("pattern:{},subscribedChannels:{}", pattern, subscribedChannels);
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        super.onSubscribe(channel, subscribedChannels);
        log.info("Channel:{},subscribedChannels:{}", channel, subscribedChannels);

    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        super.onUnsubscribe(channel, subscribedChannels);
        log.info("Channel:{},subscribedChannels:{}", channel, subscribedChannels);
    }

    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        super.onPUnsubscribe(pattern, subscribedChannels);
        log.info("pattern:{},subscribedChannels:{}", pattern, subscribedChannels);
    }
}
