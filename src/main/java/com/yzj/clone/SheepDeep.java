package com.yzj.clone;

import java.io.*;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-11-17 20:02
 */
public class SheepDeep implements Cloneable, Serializable {

    private String name;
    private Sheep child;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sheep getChild() {
        return child;
    }

    public void setChild(Sheep child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "SheepDeep{" +
                "name='" + name + '\'' +
                ", child=" + child +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        SheepDeep sheepDeep = null;
        File file = new File("sheep");
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos);
             FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            // 序列化
            oos.writeObject(this);

            //反序列化
            sheepDeep = (SheepDeep) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return sheepDeep;
    }
}
