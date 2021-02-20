package com.yzj.gc.reference;

/**
 * @description: 强引用回收案例（强引用与对象关联中断时被回收）
 * @author: 易子建
 * @create: 2020-11-03 10:34
 */
public class StrongReferenceDemo {

    @Override
    protected void finalize() throws Throwable {    // 在实际开发中，千万不要重写finalize方法
        System.out.println("StrongReferenceDemo 被回收了");
    }

    public static void main(String[] args) {
        StrongReferenceDemo strongReferenceDemo = new StrongReferenceDemo();
        strongReferenceDemo = null; // 强引用与对象关联中断
        System.gc();
    }
}
