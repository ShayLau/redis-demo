package com.redis.demo.service;

/**
 * @author ShayLau
 * @date 2020/9/7 3:35 下午
 */
public interface LockService {

    /**
     * 获取锁
     *
     * @param key
     */
    void getLock(String key);
}
