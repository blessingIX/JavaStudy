package com.yzj.md5;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * @description:
 * @author: 易子建
 * @create: 2020-10-07 11:37
 */
public class Md5Util {
    public static final String CHARSET = "UTF-8";
    public final static String MD5(String s) {
        char[] hexDigits ={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            System.out.println("md = " + Arrays.toString(md));
            int j = md.length;
            System.out.println("j = " + j);
            char[] str = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i]; // 两个十六进制位刚好可以表示一个字节（8bit）
//                0xf = 0b00001111
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];    // 一个字节的高4位转成一个十六进制位
                str[k++] = hexDigits[byte0 & 0xf];  // 一个字节的低4位转成一个十六进制位
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String s = Md5Util.MD5("123456");
        System.out.println("s = " + s);
        if (s != null)
            System.out.println("s.length() = " + s.length());

        int b = 0b00111110;
        int x = 0xf;
//                00000011  62 / 16 3
//        &       00001111  15
//        ----------------
//                00000011  3

//                00111110  62
//        &       00001111  15
//        ----------------
//                00001110  14 E
        System.out.println(b >>> 4 & x);
        System.out.println(b & x);
    }
}
