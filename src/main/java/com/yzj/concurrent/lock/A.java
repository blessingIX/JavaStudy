package com.yzj.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-20 19:24
 */
public class A {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.increment();
            }
        }, "A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.decrement();
            }
        }, "B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.increment();
            }
        }, "C").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.decrement();
            }
        }, "D").start();
    }
}

//        Lock l = ...;
//        l.lock();
//        try {
//            // access the resource protected by this lock
//        } finally {
//            l.unlock();
//        }

class Data {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private int number = 0;

    public void increment() {
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + " => " + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrement() {
        lock.lock();
        try {
            while (number != 1) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + " => " + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

// synchronized (obj) {
//     while (<condition does not hold>)    // 条件不成立
//        obj.wait();
//     ... // Perform action appropriate to condition   // 执行适合条件的行动
// }