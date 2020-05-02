package com.gary.accounts.util;

import com.gary.accounts.bean.RedisKeyPrefix;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author 丶武僧
 * Redis工具类
 */

@Component
public class RedisUtil {

    private StringRedisTemplate stringRedisTemplate;

    public RedisUtil(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public void setString(RedisKeyPrefix keyPrefix, Long id, String value, long expireTime){
        stringRedisTemplate.opsForValue().set(keyPrefix.generateKey(id), value, expireTime);
    }

    public <T> T getString(RedisKeyPrefix keyPrefix, Long id, Class<T> clazz){
         String value = stringRedisTemplate.opsForValue().get(keyPrefix.generateKey(id));
         if(StringUtils.isBlank(value)){
             return null;
         }
         return JsonUtil.stringToObj(value, clazz);
    }

    public Boolean delStringKey(RedisKeyPrefix keyPrefix, Long id){
        return stringRedisTemplate.delete(keyPrefix.generateKey(id));
    }
}
