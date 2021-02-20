package com.yzj.lang;


/**
 * @program: JavaStudy
 * @description:
 * @author: blessing
 * @create: 2020-06-21 14:00
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = " HELLO ";
        String s2 = " hello ";
        System.out.println(s1.equalsIgnoreCase(s2));
        System.out.println(s2.trim());
        System.out.println("".isEmpty());
        System.out.println(" ".isEmpty());

        System.out.println(String.valueOf(true) instanceof String);
        System.out.println(String.valueOf(new Object()));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.toString();
    }
}
