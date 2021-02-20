package com.yzj.dataStructuresandalgorithms.backtracking;

/**
 * @program: JavaStudy
 * @description: 八皇后：有一个8x8的棋盘，希望往里放8个棋子（皇后），每行放一个棋子，每个棋子所在的行、列、对角线都不能有另一个棋子。
 * @author: blessing
 * @create: 2020-05-28 10:25
 */
public class EightQueens {
    int[] result = new int[8];
    int caseCount = 0;

    /** 回溯算法递归摆放棋子 */
    public void cal8queens(int row) {
        if (row == 8) {
            System.out.println("case" + ++caseCount + ":");
            printQueens(result);
            System.out.println();
            return;
        }
        for (int column = 0; column < 8; column++) {
            if (isOk(row, column)) {
                result[row] = column;
                cal8queens(row + 1);
            }
        }
    }

    /** 当前棋子位置是否符合要求 */
    private boolean isOk(int row, int column) {
        int leftUp = column - 1;
        int rightUp = column + 1;
        for (int i = row - 1; i >= 0; i--) {
            if (result[i] == column) return false;
            if (leftUp >= 0) {
                if (result[i] == leftUp) return false;
            }
            if (rightUp < 8) {
                if (result[i] == rightUp) return false;
            }
            leftUp--;
            rightUp++;
        }
        return true;
    }

    /** 打印棋盘 */
    private void printQueens(int[] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < 8; j++) {
                if (result[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        eightQueens.cal8queens(0);
    }
}
