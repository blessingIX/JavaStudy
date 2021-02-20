package com.yzj.redis;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-11-10 09:58
 */
public class Test {

    public static void main(String[] args) {

        String key1 = RedisUtils.keyBuilder("module", "func", "123", "456");
        System.out.println("key1 = " + key1);

        RedisEnum redisEnum = RedisEnum.MDM_MSTDATADICTIONARYSERVICE_QUERYLISTBYENTITYREDIS;
        String key2 = RedisUtils.keyBuilder(redisEnum, "{\"name\": \"zhangsan\"}");
        System.out.println("key2 = " + key2);

    }

}
