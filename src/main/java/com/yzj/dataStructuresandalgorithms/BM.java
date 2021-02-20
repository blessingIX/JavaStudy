package com.yzj.dataStructuresandalgorithms;

/**
 * @program: JavaStudy
 * @description: BM字符串匹配算法
 * @author: blessing
 * @create: 2020-05-20 15:05
 */
public class BM {
    /***
    *@Description: 预处理模式串，填充suffix，prefix
    *@Param: [b, m, suffix, prefix]
    *@return: void
    *@Author: blessing
    *@date: 2020/5/20
    */
    private void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
        // 初始化suffix，prefix
        for (int i = 0; i < m; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }

        // 在模式串中查找与自身后缀匹配的子串
        for (int i = 0; i < m - 1; i++) {   // 由于是查找子串所以是 i < m - 1;
            // 其实每轮循环开始是比较b[i]和b[m - 1]，b[i]会是子串的最后一个字符
            int j = i;
            int k = 0;  // 因为每轮循环k重置为0，所以每轮循环开始是比较b[i]和b[m - 1]
            while (j >= 0 && b[j] == b[m-1-k]) {    // 每轮循环向前增长模式串后缀长度和子串长度，直到子串结束或模式串后缀与子串不匹配
                --j;    // 向前增长子串长度
                ++k;    // 向前增长模式串后缀长度
                suffix[k] = j + 1;  // 记录与长度为k的模式串后缀匹配的子串在模式串中的起始下标
            }
            if (j == -1) prefix[k] = true;  // 若子串是模式串的前缀，prefix[k] 记为true
        }
    }

    public static void main(String[] args){
        BM bm = new BM();
        String str = "123123";
        int[] suffix = new int[str.length()];
        boolean[] prefix = new boolean[str.length()];

        bm.generateGS(str.toCharArray(), str.length(), suffix, prefix);
        for (int i = 1; i < suffix.length; i++) {
            System.out.println(suffix[i]);
        }
        for (int i = 1; i < prefix.length; i++) {
            System.out.println(prefix[i]);
        }
    }
}
