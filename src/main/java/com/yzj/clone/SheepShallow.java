package com.yzj.clone;

import java.io.Serializable;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-11-17 19:58
 */
public class SheepShallow implements Cloneable, Serializable {

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
        return "SheepShallow{" +
                "name='" + name + '\'' +
                ", child=" + child +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
