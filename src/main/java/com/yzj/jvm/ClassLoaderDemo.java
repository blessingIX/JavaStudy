package com.yzj.jvm;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-12-01 17:42
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        System.out.println("ClassLoaderDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader());
        System.out.println("The Parent of ClassLoaderDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader().getParent());
        System.out.println("The GrandParent of ClassLoaderDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader().getParent().getParent());
    }
}
