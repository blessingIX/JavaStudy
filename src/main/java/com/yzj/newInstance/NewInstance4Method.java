package com.yzj.newInstance;

import java.io.*;

/**
 * @description: 创建对象的4种方式
 * @author: 易子建
 * @create: 2020-11-17 17:02
 */
public class NewInstance4Method {

    public static void main(String[] args) {

        newMethod();
        reflectMethod();
        cloneMethod();
        serializationMethod();

    }

    public static void newMethod() {
        HelloWorld helloWorld = new HelloWorld();
        // toString
        System.out.println("helloWorld = " + helloWorld);
        //测试方法
        helloWorld.sayHello();
    }

    public static void reflectMethod() {
        Class<HelloWorld> helloWorldClass = HelloWorld.class;
        try {
            HelloWorld helloWorld = helloWorldClass.newInstance();
            // toString
            System.out.println("helloWorld = " + helloWorld);
            //测试方法
            helloWorld.sayHello();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void cloneMethod() {
        HelloWorld clone = new HelloWorld();
        try {
            HelloWorld helloWorld = (HelloWorld) clone.clone();
            // toString
            System.out.println("helloWorld = " + helloWorld);
            //测试方法
            helloWorld.sayHello();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public static void serializationMethod() {
        HelloWorld h = new HelloWorld();

        //准备一个文件用于存储该对象的信息
        File f = new File("helloworld");

        try (FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis)) {
            //序列化对象，写入到磁盘中
            oos.writeObject(h);
            //反序列化对象
            HelloWorld helloWorld = (HelloWorld) ois.readObject();

            // toString
            System.out.println("helloWorld = " + helloWorld);
            //测试方法
            helloWorld.sayHello();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
