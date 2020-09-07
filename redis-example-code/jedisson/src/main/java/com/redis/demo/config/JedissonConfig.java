package com.redis.demo.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.api.RedissonReactiveClient;
import org.redisson.api.RedissonRxClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * Jedisson 配置
 *
 * @author ShayLau
 */
@Configuration
public class JedissonConfig {


    public Config config() {
        Config config = null;
        try {
            Resource resource = new ClassPathResource("redisson/SingleRedisson.yml");
            config = Config.fromYAML(resource.getFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return config;
    }


    @Bean
    public RedissonClient redissonClient() {
        RedissonClient redissonClient = Redisson.create(config());
        return redissonClient;
    }

    @Bean
    public RedissonReactiveClient reActiveClient() {
        RedissonReactiveClient reactiveClient = Redisson.createReactive(config());
        return reactiveClient;
    }

    @Bean
    public RedissonRxClient rxClient() {
        RedissonRxClient rxClient = Redisson.createRx(config());
        return rxClient;
    }


}
