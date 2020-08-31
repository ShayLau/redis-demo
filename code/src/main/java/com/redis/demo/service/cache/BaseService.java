package com.redis.demo.service.cache;

/**
 * @Author: ShayLau
 * @Date: 2020/8/31 15:50
 */
public interface BaseService {
    void set(String key, Object value);

    Object get(String key);
}
