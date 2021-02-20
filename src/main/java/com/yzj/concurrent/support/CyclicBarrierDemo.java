package com.yzj.concurrent.support;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: CyclicBarrier（循环屏障）---
 * @author: 易子建
 * @create: 2020-10-23 15:42
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        int count = 7;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(count, () -> {
            System.out.println("集齐" + count +  "颗龙珠，召唤神龙");
        });

        for (int i = 0; i < count; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "获得龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i + 1)).start();
        }

    }

}
