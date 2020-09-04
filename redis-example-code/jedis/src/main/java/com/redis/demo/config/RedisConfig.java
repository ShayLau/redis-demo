package com.redis.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

/**
 * Jedis 配置
 *
 * @author ShayLau
 */
@Configuration
public class RedisConfig {
    @Bean
    public Jedis jedis() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        return jedis;
    }
}
