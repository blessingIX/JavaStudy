package com.yzj.concurrent.state;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-17 10:22
 */
public class StateTest {
    public static void main(String[] args) throws InterruptedException {
//        testStateNew();
//        testStartMethod();
        StateTest stateTest = new StateTest();
//        stateTest.blockedTest1();
//        stateTest.blockedTest2();
//        stateTest.blockedTest3();
        stateTest.blockedTest4();
    }

    private static void testStateNew() {
//        处于NEW状态的线程此时尚未启动。这里的尚未启动指的是还没调用Thread实例的start()方法。
        Thread thread = new Thread(() -> {});
        System.out.println(thread.getState()); // 输出 NEW
    }

    public static void testStartMethod() {
//        Exception in thread "main" java.lang.IllegalThreadStateException
        Thread thread = new Thread(() -> {});
        thread.start(); // 第一次调用
        thread.start(); // 第二次调用
    }

    public void blockedTest1() throws InterruptedException {

        Thread a = new Thread(this::testMethod, "a");
        Thread b = new Thread(this::testMethod, "b");

        a.start();
        b.start();
        System.out.println(a.getName() + ":" + a.getState()); // 输出？
        System.out.println(b.getName() + ":" + b.getState()); // 输出？
    }

    public void blockedTest2() throws InterruptedException {

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "a");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "b");

        a.start();
        Thread.sleep(1000L); // 需要注意这里main线程休眠了1000毫秒，而testMethod()里休眠了2000毫秒
        b.start();
        System.out.println(a.getName() + ":" + a.getState()); // 输出？
        System.out.println(b.getName() + ":" + b.getState()); // 输出？
    }

    public void blockedTest3() throws InterruptedException {

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "a");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "b");

        a.start();
        a.join();
        b.start();
        System.out.println(a.getName() + ":" + a.getState()); // 输出？
        System.out.println(b.getName() + ":" + b.getState()); // 输出？
    }

    public void blockedTest4() throws InterruptedException {

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "a");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "b");

        a.start();
        a.join(1000L);
        b.start();
        System.out.println(a.getName() + ":" + a.getState()); // 输出？
        System.out.println(b.getName() + ":" + b.getState()); // 输出？
    }

    // 同步方法争夺锁
    private synchronized void testMethod() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
