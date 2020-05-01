package com.chuan.accounts.util;

import com.alibaba.fastjson.JSON;

/**
 * @author 丶武僧
 * Json序列化工具
 */

public class JsonUtil {

    public static <T> T stringToObj(String json, Class<T> clazz){
        return JSON.parseObject(json, clazz);
    }

    public static <T> String objToString(T obj){
        return JSON.toJSONString(obj);
    }
}
