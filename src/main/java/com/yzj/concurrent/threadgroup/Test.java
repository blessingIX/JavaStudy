package com.yzj.concurrent.threadgroup;

/**
 * @program: JavaStudy
 * @description:
 * @author: blessing
 * @create: 2020-05-19 13:33
 */
public class Test {
    public static void main(String[] args){
        ThreadGroup threadGroup = new ThreadGroup("test");
        Task task = new Task();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(threadGroup, task);
            thread.start();
        }

        threadGroup.list();

        System.out.println("activeCount: " + threadGroup.activeCount());
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for (int i = 0; i < threads.length; i++) {
            System.out.println(threads[i].getName());
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        threadGroup.interrupt();
    }
}
