package com.chuan.accounts.util;

import com.alibaba.fastjson.JSON;

public class JsonUtil {

    public static <T> T stringToObj(String json, Class<T> clazz){
        return JSON.parseObject(json, clazz);
    }

    public static <T> String objToString(T obj){
        return JSON.toJSONString(obj);
    }
}
