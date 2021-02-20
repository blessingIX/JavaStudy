package com.yzj.concurrent.rw;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-23 23:20
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {

        MyCache cache = new MyCache();

        for (int i = 0; i < 5; i++) {
            final int n = i;
            new Thread(() -> {
                cache.put(String.valueOf(n + 1), n + 1);
            }, String.valueOf(i + 1)).start();
        }

        for (int i = 0; i < 5; i++) {
            final int n = i;
            new Thread(() -> {
                cache.get(String.valueOf(n + 1));
            }, String.valueOf(i + 1)).start();
        }
    }

}

class MyCache {

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Map<String, Object> map = new HashMap<>();

    public void put(String key, Object value) {
        readWriteLock.writeLock().lock();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(Thread.currentThread().getName() + "写" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写OK");
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key) {
        readWriteLock.readLock().lock();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(Thread.currentThread().getName() + "读" + key);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读OK");
        } finally {
            readWriteLock.readLock().unlock();
        }
    }


}