package com.yzj.concurrent.deadlock;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-29 10:44
 */
public class DeadLockDemo {

    private static final Object obj1 = new Object();
    private static final Object obj2 = new Object();

    public static void main(String[] args) {

        Thread a = new Thread(() -> {
            synchronized (DeadLockDemo.obj1) {
                System.out.println(Thread.currentThread().getName() + " locked obj1");
                while (true) {
                    synchronized (DeadLockDemo.obj2) {
                        System.out.println(Thread.currentThread().getName() + " locked obj2");
                    }
                }
            }
        }, "A");

        Thread b = new Thread(() -> {
            synchronized (DeadLockDemo.obj2) {
                System.out.println(Thread.currentThread().getName() + " locked obj2");
                while (true) {
                    synchronized (DeadLockDemo.obj1) {
                        System.out.println(Thread.currentThread().getName() + " locked obj1");
                    }
                }
            }
        }, "B");

        a.start();
        b.start();
    }

}
