package com.yzj.concurrent.lock;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @description: 自己实现自旋锁案例
 * @author: 易子建
 * @create: 2020-11-02 16:44
 */
public class SpinLockDemo {

    private AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock() {
        Thread thread = Thread.currentThread();
        while (!atomicReference.compareAndSet(null, thread)) {  // 自旋

        }
        System.out.println(thread.getName() + " get lock.");
    }

    public void unlock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + " release lock.");
        atomicReference.compareAndSet(thread, null);
    }

}

class TestSpinLock {
    
    public static void main(String[] args) {
//        A get lock.
//        <此处B未获得锁，自旋了3秒>
//        A release lock.
//        B get lock.
//        B release lock.

        SpinLockDemo lockDemo = new SpinLockDemo();
        new Thread(() -> {
            lockDemo.lock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lockDemo.unlock();
        }, "A").start();

        new Thread(() -> {
            lockDemo.lock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lockDemo.unlock();
        }, "B").start();
        
    }
    
}