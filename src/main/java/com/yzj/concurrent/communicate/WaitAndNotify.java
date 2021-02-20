package com.yzj.concurrent.communicate;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-17 15:27
 */
public class WaitAndNotify {
    private static final Object lock = new Object();

    static class ThreadA implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 100; i++) {
                    try {
                        lock.notify();
                        lock.wait();
                        System.out.println("Thread A " + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class ThreadB implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 100; i++) {
                    try {
                        lock.notify();
                        lock.wait();
                        System.out.println("Thread B " + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep(1000);
        new Thread(new ThreadB()).start();
    }
}
