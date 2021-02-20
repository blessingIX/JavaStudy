package com.yzj.concurrent.jmm;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-28 17:28
 */
public class JMMDemo {

    private static /*volatile*/ int num = 0;

    public static void main(String[] args) {

        new Thread(() -> {
            while (num == 0) {
                System.out.println();   // 若不加此条语句，此线程不会停止，加了这句话会停止是因为println() 内有synchronized
            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        num = 1;
        System.out.println(num);


    }

}
