package com.yzj.concurrent.lock;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-20 22:13
 */
public class Lock8 {

    public static void main(String[] args) {

        Phone phone = new Phone();

        new Thread(()->{
            try {
                phone.sendSms();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            try {
                phone.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();

    }

}

class Phone {

    public synchronized void sendSms() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("发短信");
    }

    public synchronized void call() {
        System.out.println("打电话");
    }

}