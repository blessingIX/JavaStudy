package com.yzj.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-11-05 20:45
 */
public class Demo {

    public static void main(String[] args) {

//        Hashtable<String, Integer> hashtable = new Hashtable<>();
//        HashMap<String, Integer> hashMap = new HashMap<>();
//        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        Map<Integer, String> map = new TreeMap<>();
        map.put(1, "1");
        System.out.println("size = " + map.size());
        map.put(2, "2");
        System.out.println("size = " + map.size());
        map.put(2, "22");
        System.out.println("size = " + map.size());
        map.put(3, "3");
        System.out.println("size = " + map.size());

        for (Map.Entry<Integer, String> integerStringEntry : map.entrySet()) {
            System.out.println(integerStringEntry.getKey());
            System.out.println(integerStringEntry.getValue());
        }
    }

}
