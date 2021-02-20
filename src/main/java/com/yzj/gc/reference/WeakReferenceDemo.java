package com.yzj.gc.reference;

import java.lang.ref.WeakReference;

/**
 * @description: 弱引用回收案例（触发gc时回收，不论是否内存溢出）
 * @author: 易子建
 * @create: 2020-11-03 11:02
 */
public class WeakReferenceDemo {

    public static void main(String[] args) {

        WeakReference<byte[]> weakReference = new WeakReference<>(new byte[1]);
        System.out.println(weakReference.get());
        System.gc();
        System.out.println(weakReference.get());    // null

        // 应用：比如ThreadLocal、WeakHashMap
    }

}
