package com.yzj.clone;

import java.io.*;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-11-17 19:59
 */
public class DiffDeepCopyAndShallowCopy {

    public static void main(String[] args) throws CloneNotSupportedException {

//        serializable();   // 项目根目录sheep文件中
        // shallow
        Sheep sheepShallowChild = new Sheep();
        SheepShallow sheepShallow = new SheepShallow();
        sheepShallow.setName("shallow clone sheep");
        sheepShallow.setChild(sheepShallowChild);
        System.out.println("sheepShallow = " + sheepShallow);
        SheepShallow sheepShallowClone = (SheepShallow) sheepShallow.clone();
        System.out.println("sheepShallowClone = " + sheepShallowClone);
        System.out.println(sheepShallow.getChild() == sheepShallowClone.getChild());

        // deep
        Sheep sheepDeepChild = new Sheep();
        SheepDeep sheepDeep = new SheepDeep();
        sheepDeep.setName("deep clone sheep");
        sheepDeep.setChild(sheepDeepChild);
        System.out.println("sheepDeep = " + sheepDeep);
        SheepDeep sheepDeepClone = (SheepDeep) sheepDeep.clone();
        System.out.println("sheepDeepClone = " + sheepDeepClone);
        System.out.println(sheepDeep.getChild() == sheepDeepClone.getChild());

    }

    public static void serializable() {
        SheepDeep sheepDeep = new SheepDeep();
        sheepDeep.setName("deep clone sheep's child");
        File file = new File("sheep");

        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            // 序列化
            oos.writeObject(sheepDeep);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
