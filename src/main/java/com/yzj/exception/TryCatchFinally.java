package com.yzj.exception;

/**
 * @description: 验证发生异常后的语句是否执行、return，finally执行顺序
 * @author: yzj
 * @create: 2020-11-18 19:53
 */
public class TryCatchFinally {

    public static void main(String[] args) {
//        tryRemainingStatement();
        System.out.println(finallyReturn());
    }

    public static void tryRemainingStatement() {
        try {
            System.out.println("before");
            int i = 1 / 0;
            System.out.println("after");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int finallyReturn() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            System.out.println("finally");
        }
        return 1;
    }

}
