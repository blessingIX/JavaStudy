package com.yzj.gc;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-31 15:35
 */
public class LoopReferenceDemo {
    public static void main(String[] args) {
        A a = new A();  // a引用计数器+1 (1)
        B b = new B();  // b引用计数器+1 (1)

        a.b = b;    // b的引用计数器+1 (2)
        b.a = a;    // a的引用计数器+1 (2)

        a = null;   // a引用计数器-1 (1)
        b = null;   // b引用计数器-1 (1)
    }
}

class A {
    public B b;
}

class B {
    public A a;
}