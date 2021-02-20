package com.yzj.concurrent.support;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @description: Semaphore（信号量）
 * @author: 易子建
 * @create: 2020-10-23 16:11
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        int parkingSpace = 3;
        int carsCount = 6;

        Semaphore semaphore = new Semaphore(parkingSpace);

        System.out.println(String.format("共%d个停车位，%d辆车", parkingSpace, carsCount));
        for (int i = 0; i < carsCount; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    int time = new Random().nextInt(10) + 1;
                    System.out.println(Thread.currentThread().getName() + "获得停车位，停车" + time + "秒");
                    TimeUnit.SECONDS.sleep(time);
                    System.out.println(Thread.currentThread().getName() + "离开停车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i + 1)).start();
        }
    }

}
