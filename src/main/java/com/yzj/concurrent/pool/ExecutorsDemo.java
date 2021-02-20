package com.yzj.concurrent.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-27 09:23
 */
public class ExecutorsDemo {

    /*
    线程池三大方法
    newSingleThreadExecutor();  // 单个线程的线程池
    newFixedThreadPool(int n);  // 固定大小的线程池
    newCachedThreadPool();      // 伸缩大小的线程池
     */

    public static void main(String[] args) {
//        newSingleThreadExecutor();
//        newFixedThreadPool();
        newCachedThreadPool();
    }

    public static void newSingleThreadExecutor() {

        System.out.println("==newSingleThreadExecutor()==");
        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        try {
            for (int i = 0; i < 100; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " OK");
                });
            }
        } finally {
            threadPool.shutdown();
        }

    }

    public static void newFixedThreadPool() {

        System.out.println("==newFixedThreadPool()==");
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        try {
            for (int i = 0; i < 100; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " OK");
                });
            }
        } finally {
            threadPool.shutdown();
        }

    }

    public static void newCachedThreadPool() {

        System.out.println("==newCachedThreadPool()==");
        ExecutorService threadPool = Executors.newCachedThreadPool();

        try {
            for (int i = 0; i < 100; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " OK");
                });
            }
        } finally {
            threadPool.shutdown();
        }

    }

}
