package com.yzj.gc.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @description: 虚引用（幻影引用）回收案例
 * @author: 易子建
 * @create: 2020-11-03 11:22
 */
public class PhantomReferenceDemo {

    public static void main(String[] args) {

        ReferenceQueue queue = new ReferenceQueue();
        List<byte[]> bytes = new ArrayList<>();
        // 虚引用的特点之二：虚引用必须与ReferenceQueue一起使用，当GC准备回收一个对象，如果发现它还有虚引用，就会在回收之前，把这个虚引用加入到与之关联的ReferenceQueue中
        PhantomReference<Student> reference = new PhantomReference<Student>(new Student(), queue);

        System.out.println(reference.get());    // 虚引用特点之一：无法通过虚引用来获取对一个对象的真实引用

        new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                bytes.add(new byte[1024 * 1024]);   // 存入的数据越来越多，发生gc
            }
        }, "A").start();

        new Thread(() -> {
            while (true) {
                Reference poll = queue.poll();
                if (poll != null) {
                    System.out.println("虚引用被回收了：" + poll);
                }
            }
        }, "B").start();

        Scanner scanner = new Scanner(System.in);
        scanner.hasNext();
    }

}

class Student {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Student 被回收了");
    }
}