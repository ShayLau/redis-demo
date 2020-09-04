package com.redis.demo.service.impl;

import com.redis.demo.service.DistributedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;

/**
 * 分布式锁实现
 */
@Service
public class DistributedLockServiceImpl implements DistributedService {

    @Autowired
    private Jedis jedis;

    /**
     * 锁成功
     */
    private static final String LOCK_SUCCESS = "OK";
    /**
     * 如果不存在 Not_exist==NX
     */
    private static final String SET_IF_NOT_EXIST = "NX";
    /**
     * 失效时间
     */
    private static final String SET_WITH_EXPIRE_TIME = "PX";


    /**
     * 尝试获取锁
     *
     * @param lockKey    锁key
     * @param requestId  请求id
     * @param expireTime 失效时间
     * @return
     */
    @Deprecated
    public boolean tryGetLock(String lockKey, String requestId, int expireTime) {
        ///Jedis 2.9.0 Key设置锁
        /*String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);

        if (result.equals(LOCK_SUCCESS)) {
            return true;
        }*/
        return false;
    }


    /**
     * 尝试设置锁
     * <description>
     * Jedis 3.3.0版本中将set key时的参数抽象为SetParam
     * <p>
     * params NX|XX, NX -- Only set the key if it does not already exist. XX -- Only set the
     * key if it already exist. EX|PX, expire time units: EX = seconds; PX = milliseconds
     * </p>
     * </description>
     *
     * @param lockKey    锁key
     * @param requestId  请求id
     * @param expireTime 失效时间
     * @return
     */
    @Override
    public boolean trySetKeyLock(String lockKey, String requestId, int expireTime) {
        //获取锁时的参数
        SetParams setParams = new SetParams();
        //key not exist、key expireTime
        setParams.nx().px(expireTime);
        if (jedis.set(lockKey, requestId, setParams).equals(LOCK_SUCCESS)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean unLock(String lockKey, String requestId) {
        //该方法容易导致分布式环境错误解锁
        jedis.del(lockKey);

        String luaScript = "";

        Object result = jedis.eval(luaScript, Collections.singletonList(lockKey), Collections.singletonList(requestId));
        System.out.println(result);
        return false;
    }
}
