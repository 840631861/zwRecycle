package com.example;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

public class FastjsonHelper {
    public static <T> String serialize(T object) {
               return JSON.toJSONString(object);
           }

    public static <T> T deserialize(String json, Class<T> clz) {
             return JSON.parseObject(json, clz);
           }
    public static <T> List<T> deserializeList(String json, Class<T> clz) {
                return JSON.parseArray(json, clz);
            }
    public static <T> T deserializeAny(String json, TypeReference<T> type) {
               return JSON.parseObject(json, type);
           }
}
