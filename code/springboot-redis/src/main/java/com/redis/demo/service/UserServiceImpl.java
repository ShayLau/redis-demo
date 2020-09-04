package com.redis.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ClusterOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * @Author: ShayLau
 * @Date: 2020/8/28 15:28
 */
public class UserServiceImpl implements UserService {


    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    private final String isLogin = "user:login";

    /**
     * 签到
     *
     * @param userId 用户编号
     */
    @Override
    public void signIn(Long userId) {

        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();

        valueOperations.setBit(isLogin, userId, true);

        ///
        ///byte[] keys = isLogin.getBytes();
        ///long key = userId.longValue();
        ///redisTemplate.execute((connection -> connection.setBit(keys, key, true)), true);


    }

    @Override
    public void cluster() {
        ClusterOperations<String, Object> clusterOperations = redisTemplate.opsForCluster();
    }
}
