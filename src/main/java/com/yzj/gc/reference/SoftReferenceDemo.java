package com.yzj.gc.reference;

import java.lang.ref.SoftReference;

/**
 * @description: 软引用回收案例（发生内存溢出前被回收）
 * @author 易子建
 * @create: 2020-11-03 10:41
 */
public class SoftReferenceDemo {

    public static void main(String[] args) {    // VM options: -Xmx20m
        // 设置java程序能获得的最大堆大小为20m

        SoftReference<byte[]> softReference = new SoftReference<>(new byte[1024 * 1024 * 10]);  // 10m
        System.out.println(softReference.get());
        System.gc();
        System.out.println(softReference.get());

        byte[] bytes = new byte[1024 * 1024 * 10];  // 10m，内存溢出
        System.out.println(softReference.get());    // null，softReference软引用被回收

        // 应用：缓存，内存溢出时先干掉软引用
    }

}
