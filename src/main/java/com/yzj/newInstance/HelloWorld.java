package com.yzj.newInstance;

import java.io.Serializable;

/**
 * @description: 测试类
 * @author: 易子建
 * @create: 2020-11-17 17:00
 */
public class HelloWorld implements Cloneable, Serializable {

    private String msg = "hello world";
    private transient int hidden = 1;   // transient修饰的属性不会被序列化
    private Ref ref = new Ref();

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getHidden() {
        return hidden;
    }

    public void setHidden(int hidden) {
        this.hidden = hidden;
    }

    public void sayHello() {
        System.out.println("hello world");
    }

    public Ref getRef() {
        return ref;
    }

    public void setRef(Ref ref) {
        this.ref = ref;
    }

    @Override
    public String toString() {
        return "HelloWorld{" +
                "msg='" + msg + '\'' +
                ", hidden=" + hidden +
                ", ref=" + ref +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
