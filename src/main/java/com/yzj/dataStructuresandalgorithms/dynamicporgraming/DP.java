package com.yzj.dataStructuresandalgorithms.dynamicporgraming;

import java.util.HashMap;

/**
 * @program: JavaStudy
 * @description:
 * @author: blessing
 * @create: 2020-07-11 10:22
 */
public class DP {
    public int stairs(int n) {
//        走楼梯，共n阶楼梯，每步1阶或2阶，求多少种走法。
//        递归法
        if(n < 1) {
            return 0;
        } else if (n == 1) {
            return 1;
        }else if (n == 2) {
            return 2;
        }
        return stairs(n - 1) + stairs(n - 2);
    }

    public int stairs(int n, HashMap<Integer, Integer> map) {
//        备忘录法
        if(n < 1) {
            return 0;
        } else if (n == 1) {
            return 1;
        }else if (n == 2) {
            return 2;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int value = stairs(n - 1) + stairs(n - 2);
            map.put(n, value);
            return value;
        }
    }

    public int stairs_dp(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int temp = 0;
        for (int i = 2; i < n; i++) {
            temp = a + b;   // 状态转移方程   每步走1阶或2阶，所以第i阶 = 第i-1阶走法（从i-1阶走1步到第i阶） + 第i-2阶走法（从i-2阶走2步到第i阶）
            a = b;
            b = temp;
        }
        return temp;
    }

    public static void main(String[] args) {
        DP dp = new DP();
        System.out.println(dp.stairs(10));

        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println(dp.stairs(10, map));

        System.out.println(dp.stairs_dp(10));
    }
}
