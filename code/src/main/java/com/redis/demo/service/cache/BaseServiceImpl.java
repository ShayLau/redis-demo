package com.redis.demo.service.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

/**
 * @Author: ShayLau
 * @Date: 2020/8/31 15:50
 */
@Service
public class BaseServiceImpl implements BaseService {

    @Autowired
    private JedisCluster jedisCluster;


    @Override
    public void set(String key, Object value) {
        jedisCluster.set(key, value.toString());
    }

    @Override
    public Object get(String key) {
        return jedisCluster.get(key);
    }


    public void clusterInfo(){
    }
}
