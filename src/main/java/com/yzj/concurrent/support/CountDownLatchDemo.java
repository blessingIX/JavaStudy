package com.yzj.concurrent.support;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @description: CountDownLatch（倒计时闩锁）
 * @author: 易子建
 * @create: 2020-10-23 15:38
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        int count = 10;
        CountDownLatch countDownLatch = new CountDownLatch(count);

        System.out.println(String.format("夜深了，还有%d到位同学在教室自习", count));
        for (int i = 0; i < count; i++) {
            final int n = i;
            new Thread(() -> {
                int time = new Random().nextInt(10) + 1;
                try {
                    TimeUnit.SECONDS.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("同学" + n + "了离开教室");
                countDownLatch.countDown();
            }, String.valueOf(i + 1)).start();
        }

        countDownLatch.await();
        System.out.println("锁门");

    }

}
