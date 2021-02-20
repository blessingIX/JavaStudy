package com.yzj.dataStructuresandalgorithms;

/**
 * @program: JavaStudy
 * @description: KMP字符出匹配算法
 * @author: blessing
 * @create: 2020-05-27 09:34
 */
public class KMP {
    private static int[] next;

    public static int kmp(String string, String pattern) {
        int j = 0;
        next = getNext(pattern);
        for (int i = 0; i < string.length(); i++) {
            while (j != 0 && pattern.charAt(j) != string.charAt(i)) {
                j = next[j];
            }
            if (string.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == pattern.length()) {
                return i - pattern.length() + 1;
            }
        }
        return -1;
    }

    private static int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        int j = 0;
        for (int i = 2; i < pattern.length(); i++) {
            while (j != 0 && pattern.charAt(j) != pattern.charAt(i - 1)) {
                j = next[j];
            }
            if (pattern.charAt(j) == pattern.charAt(i - 1)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args){
        String string = "ACAADACAAB";
        String pattern = "ACAAB";
        int pos = KMP.kmp(string, pattern);
        System.out.println(pos);
        if (pos > -1)
            System.out.println(string.charAt(pos));
    }
}
