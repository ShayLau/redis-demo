package com.redis.demo.service;

/**
 * @Author: ShayLau
 * @Date: 2020/8/28 15:26
 */
public interface UserService {

    /**
     * 签到
     *
     * @param userId 用户编号
     */
    void signIn(Long userId);


}
