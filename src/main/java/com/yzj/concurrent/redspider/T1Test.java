package com.yzj.concurrent.redspider;

import java.util.stream.IntStream;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-16 19:59
 */
public class T1Test {
    public static void main(String[] args) {
//        priority();
//        testUncaughtException();
        copyThreadGroup();
    }

    public static void priority() {
        IntStream.range(1, 10).forEach(i -> {
            Thread thread = new Thread(new T1());
            thread.setPriority(i);
            thread.start();
        });
    }

    public static void testUncaughtException() {
        ThreadGroup threadGroup1 = new ThreadGroup("group1") {
            // 继承ThreadGroup并重新定义以下方法
            // 在线程成员抛出unchecked exception
            // 会执行此方法
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + ": " + e.getMessage());
            }
        };

        // 这个线程是threadGroup1的一员
        Thread thread1 = new Thread(threadGroup1, new Runnable() {
            public void run() {
                // 抛出unchecked异常
                throw new RuntimeException("测试异常");
            }
        });

        thread1.start();
    }

    public static void copyThreadGroup() {
        ThreadGroup tg = new ThreadGroup("tg");
        Thread t1 = new T1();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(tg, t1);
//            thread.start();
        }

        // 复制一个线程数组到一个线程组
        Thread[] threads = new Thread[tg.activeCount()];
        ThreadGroup threadGroup = new ThreadGroup("threadGroup");
        threadGroup.enumerate(threads);
        System.out.println(threadGroup.toString());
    }
}
