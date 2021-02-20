package com.yzj.exception;

/**
 * @description: 测试java.lang.NoClassDefFoundError和java.lang.NotClassFoundException
 * @author: 易子建
 * @create: 2020-11-18 09:12
 */
public class A {
    public static void main(String[] args) {
        notClassFoundException();
        noClassDefFoundError();
    }

    public static void noClassDefFoundError() {
        // A、B类编译完成后（运行一次即可），在target中删除B.class文件后，再次运行抛出java.lang.NoClassDefFoundError
        B b = new B();
        b.sayHello();
    }

    public static void notClassFoundException() {
        try {
            Class<?> cClass = Class.forName("com.yzj.exception.C"); // 没有C类，java.lang.ClassNotFoundException
//            ClassLoader.getSystemClassLoader().loadClass("com.yzj.exception.C");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


