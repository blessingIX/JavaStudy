package com.yzj.concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 可重入锁：获得了外面的锁，自动获得里面的锁
 * @author: 易子建
 * @create: 2020-11-02 17:01
 */
public class ReentrantLockDemo {
    private ReentrantLock lock = new ReentrantLock();

    // synchronized版
    public synchronized void method1() {
        System.out.println(Thread.currentThread().getName() + " method1");
        method2();
    }

    public synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + " method2");
    }

    // Lock版
    public void method3() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " method3");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            method4();
        } finally {
            lock.unlock();
        }
    }

    private void method4() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " method4");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
        
//        new Thread(() -> {
//            reentrantLockDemo.method1();
//        }, "A").start();
//
//        new Thread(() -> {
//            reentrantLockDemo.method1();
//        }, "B").start();


        // 输出结果：
        // C method3    //
        // C method4
        // D method4
        new Thread(() -> {
            reentrantLockDemo.method3();
        }, "C").start();

        new Thread(() -> {
            reentrantLockDemo.method3();
        }, "D").start();

    }

}
