package com.redis.demo.service;

/**
 * 分布式锁接口
 * <description>
 * Jedis 分布式锁方案
 * </description>
 */
public interface DistributedService {

    /**
     * 尝试设置锁
     *
     * @param lockKey    锁key
     * @param requestId  请求id
     * @param expireTime 失效时间
     * @return
     */
    boolean trySetKeyLock(String lockKey, String requestId, int expireTime);

    /**
     * 解锁
     *
     * @param lockKey   锁key
     * @param requestId 请求id
     * @return
     */
    boolean unLock(String lockKey, String requestId);
}
