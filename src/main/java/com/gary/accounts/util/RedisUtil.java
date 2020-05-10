package com.gary.accounts.util;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author 丶武僧
 * Redis工具类
 */

@Component
public class RedisUtil {

    private final StringRedisTemplate stringRedisTemplate;

    public RedisUtil(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public void setString(String key, String value){
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public void setStringWithExpireTime(String key, String value, long expireTime){
        stringRedisTemplate.opsForValue().set(key, value, expireTime);
    }

    public Boolean setNXWithExperiTime(String key, String value, long expireTime){
        Optional<Boolean> optional = Optional.ofNullable(stringRedisTemplate.opsForValue().setIfAbsent(key, value, expireTime, TimeUnit.MINUTES));
        return optional.orElse(false);
    }

    public String getString(String value){
         return stringRedisTemplate.opsForValue().get(value);
    }

    public Boolean delStringKey(String key){
        return stringRedisTemplate.delete(key);
    }
}
