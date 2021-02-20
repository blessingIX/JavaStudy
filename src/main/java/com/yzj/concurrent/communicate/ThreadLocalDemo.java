package com.yzj.concurrent.communicate;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-17 16:05
 */
public class ThreadLocalDemo {
//    ThreadLocal而是一个线程内部的存储类，可以在指定线程内存储数据，数据存储以后，只有指定线程可以得到存储数据

    static class ThreadA implements Runnable {
        private ThreadLocal<String> threadLocal;

        public ThreadA(ThreadLocal<String> threadLocal) {
            this.threadLocal = threadLocal;
        }

        @Override
        public void run() {
            threadLocal.set("A");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ThreadA输出：" + threadLocal.get());
        }
    }

    static class ThreadB implements Runnable {
        private ThreadLocal<String> threadLocal;
        public ThreadB(ThreadLocal<String> threadLocal) {
            this.threadLocal = threadLocal;
        }

        @Override
        public void run() {
            threadLocal.set("B");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ThreadB输出：" + threadLocal.get());
        }
    }

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
//        threadLocal.set("AB");    在外面设置threadLocal对象的值，作为参数传入线程构造方法后，线程内部不对threadLocal对象进行赋值，
//        threadLocal.get()方法会返回null
        new Thread(new ThreadA(threadLocal)).start();
        new Thread(new ThreadB(threadLocal)).start();
    }
}
