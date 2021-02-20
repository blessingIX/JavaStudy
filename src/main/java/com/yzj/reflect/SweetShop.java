package com.yzj.reflect;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-11-03 15:51
 */
public class SweetShop {

    public static void print(Object obj) {
        System.out.println(obj);
    }

    public static void main(String[] args) {

        print("inside main");
        new Candy();
        print("After creating Candy");
        try {
            Class.forName("com.yzj.reflect.Gum");
        } catch (ClassNotFoundException e) {
            print("Couldn't find Gum");
        }
        print("After Class.forName(\"com.yzj.reflect.Gum\");");
        new Cookie();
        print("After creating Cookie");

    }

}

class Candy {
    static {
        System.out.println("Loading Candy");
    }
}

class Gum {
    static {
        System.out.println("Loading Gum");
    }
}

class Cookie {
    static {
        System.out.println("Loading Cookie");
    }
}