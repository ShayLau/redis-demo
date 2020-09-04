package com.redis.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * redis 集群配置
 *
 * @Author: ShayLau
 * @Date: 2020/8/31 15:41
 */
@Configuration
public class RedisClusterConfig {

    /**
     * 集群节点
     */
    @Value("${spring.redis.cluster.nodes}")
    private String nodes;

    @Bean
    public JedisCluster jedisCluster() {
        String[] cNodes = nodes.split(",");
        Set<HostAndPort> set = new HashSet<>();
        //分割出集群点
        for (String node : cNodes) {
            String[] hp = node.split(":");
            set.add(new HostAndPort(hp[0], Integer.parseInt(hp[1])));
        }
        JedisCluster jedisCluster = new JedisCluster(set);
        return jedisCluster;
    }


}
