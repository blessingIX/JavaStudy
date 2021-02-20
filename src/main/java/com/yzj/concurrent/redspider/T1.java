package com.yzj.concurrent.redspider;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-16 19:58
 */
public class T1 extends Thread {
    @Override
    public void run() {
        System.out.println(String.format("当前执行的线程是：%s，优先级：%d",
                Thread.currentThread().getName(),
                Thread.currentThread().getPriority()));
    }
}
