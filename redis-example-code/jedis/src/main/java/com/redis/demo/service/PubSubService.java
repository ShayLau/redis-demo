package com.redis.demo.service;

/**
 * @author ShayLau
 * @date 2020/9/8 1:21 下午
 */
public interface PubSubService {

    /**
     * 订阅频道
     *
     * @param channels 频道名称
     */
    void subscribeChannel(String... channels);


    /**
     * 取消订阅频道
     *
     * @param channels 频道名称
     */
    void unSubscribeChannel(String... channels);


}
