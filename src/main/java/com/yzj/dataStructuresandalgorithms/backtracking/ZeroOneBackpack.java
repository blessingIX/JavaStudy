package com.yzj.dataStructuresandalgorithms.backtracking;

/**
 * @program: JavaStudy
 * @description: 有一个背包，背包总的承载重量是Wkg。有n个物品，每个物品的重量不等，并且不可分割。期望选择几件物
 * 品，装载到背包中。在不超过背包所能装载重量的前提下，让背包中物品的总重量最大。
 * @author: blessing
 * @create: 2020-05-28 11:23
 */
public class ZeroOneBackpack {
    public int maxW = Integer.MIN_VALUE;

    public void f(int i, int cw, int[] items, int n, int w) {
        if (cw == w || i == n) { // cw==w表示装满了;i==n表示已经考察完所有的物品
            if (cw > maxW) maxW = cw;
            return;
        }

        f(i + 1, cw, items, n, w); //选择不装第i个物品
        if (cw + items[i] <= w) // 已经超过可以背包承受的重量的时候，就不要再装了
            f(i + 1, cw + items[i], items, n, w); // 选择装第i个物品
    }

    public static void main(String[] args) {
        ZeroOneBackpack backpack = new ZeroOneBackpack();
        int[] items = new int[]{2, 5, 4, 6, 3};
        backpack.f(0, 0, items, items.length, 10);
        System.out.println(backpack.maxW);
    }
}

/**
 * 整体思路：
 * 回溯算法本质上就是枚举，优点在于其类似于摸着石头过河的查找策略，且可以通过剪枝少走冤枉路。
 * 01背包问题中对于n个物品来说，总的装法就有2^n种，去掉总重量超过Wkg的，从剩下的装法中选择总重量最接近Wkg的。
 * 每个物品有两种装法：装与不装。
 * 第i个物品不装：f(i + 1, cw, items, n, w);
 * 第i个物品装：f(i + 1, cw + items[i], items, n, w);
 * 但对于如果当前物品装入被背包会超过背包容量的物品选择不装：if (cw + items[i] > w) return;
 */