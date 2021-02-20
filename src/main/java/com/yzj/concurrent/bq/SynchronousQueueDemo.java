package com.yzj.concurrent.bq;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-24 17:41
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> synchronousQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + ": a ==> Q");
                synchronousQueue.put("a");
                System.out.println(Thread.currentThread().getName() + ": b ==> Q");
                synchronousQueue.put("b");
                System.out.println(Thread.currentThread().getName() + ": c ==> Q");
                synchronousQueue.put("c");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T1").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + ": " + synchronousQueue.take() + " <== Q");
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + ": " + synchronousQueue.take() + " <== Q");
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + ": " + synchronousQueue.take() + " <== Q");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T2").start();

    }

}