package com.yzj.concurrent.unsafe;

import java.util.*;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-20 22:51
 */
public class ListTest {

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list);
            }, String.valueOf(i + 1)).start();
        }
    }

}
