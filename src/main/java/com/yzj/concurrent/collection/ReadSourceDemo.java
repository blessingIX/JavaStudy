package com.yzj.concurrent.collection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: yzj
 * @create: 2020-11-21 16:50
 */
public class ReadSourceDemo {

    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("1", "one");
    }

}
