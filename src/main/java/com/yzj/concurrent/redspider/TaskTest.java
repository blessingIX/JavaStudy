package com.yzj.concurrent.redspider;


import java.util.concurrent.*;

public class TaskTest {
    public static void main(String[] args) {
//        future();
//        futureTask();
        threadGroup();
    }

    public static void future() {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> future = executor.submit(new Task());
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }

    public static void futureTask() {
        ExecutorService executor = Executors.newCachedThreadPool();
        FutureTask<Integer> futureTask = new FutureTask<>(new Task());
        executor.submit(futureTask);
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }

    public static void threadGroup() {
        Thread testThread = new Thread(() -> {
            System.out.println("testThread当前线程组名字：" + Thread.currentThread().getThreadGroup().getName());
            System.out.println("testThread线程名字：" + Thread.currentThread().getName());
        });

        testThread.start();
        System.out.println("执行main方法线程名字：" + Thread.currentThread().getName());
    }
}