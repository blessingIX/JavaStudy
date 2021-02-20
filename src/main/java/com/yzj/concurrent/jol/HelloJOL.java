package com.yzj.concurrent.jol;

import org.openjdk.jol.info.ClassLayout;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-11-28 14:41
 */
public class HelloJOL {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
