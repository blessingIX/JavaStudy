package com.yzj.concurrent.threadgroup;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @program: JavaStudy
 * @description:
 * @author: blessing
 * @create: 2020-05-19 13:38
 */
public class Task implements Runnable {

    @Override
    public void run() {
        Random random = new Random();
        int duration = random.nextInt(20) * 1000;
        System.out.println(Thread.currentThread().getName() + " is running");
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " stop");
            e.printStackTrace();
        }
    }
}
