package com.yzj.concurrent.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-29 15:17
 */
public class ABAQuestionStamp {

//    private static AtomicStampedReference<Integer> reference = new AtomicStampedReference<>(2020, 1);
    private static AtomicStampedReference<Integer> reference = new AtomicStampedReference<>(1, 1);
//private static AtomicStampedReference<Integer> reference = new AtomicStampedReference<>(Integer.valueOf(2020), 1);

    public static void main(String[] args) {

//        int a1e = 2020;
//        int a1n = 2022;
//        int a2e = 2022;
//        int a2n = 2020;
//
//        int be = 2020;
//        int bn = 2023;

        int a1e = 1;
        int a1n = 2;
        int a2e = 2;
        int a2n = 1;

        int be = 1;
        int bn = 3;

        new Thread(() -> {
            int stamp = reference.getStamp();
            System.out.println("a.stamp = " + stamp);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(reference.compareAndSet(a1e, a1n, reference.getStamp(), reference.getStamp() + 1));
            System.out.println("a1 -> " + reference.getStamp());

            System.out.println(reference.compareAndSet(a2e, a2n, reference.getStamp(), reference.getStamp() + 1));
            System.out.println("a2 -> " + reference.getStamp());
        }, "A").start();

        new Thread(() -> {
            int stamp = reference.getStamp();
            System.out.println("b.stamp = " + stamp);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(reference.compareAndSet(be, bn, stamp, stamp + 1));
            System.out.println("b - > " + reference.getStamp());
        }, "B").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(reference.get(new int[10]));

    }

}
