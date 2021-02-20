package com.yzj.collection;

import java.util.*;

/**
 * @description:
 * @author: yzj
 * @create: 2020-11-21 16:01
 */
public class SafeCollection {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> stringList = Collections.synchronizedList(list);

        Map<String, String> map = new HashMap<>();
        Map<String, String> stringMap = Collections.synchronizedMap(map);

        Set<String> set = new HashSet<>();
        Set<String> stringSet = Collections.synchronizedSet(set);
    }

}
