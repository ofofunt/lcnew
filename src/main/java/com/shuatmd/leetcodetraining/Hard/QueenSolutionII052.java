package com.shuatmd.leetcodetraining.Hard;

import java.util.HashSet;
import java.util.Set;

//52. N 皇后 II
//n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
public class QueenSolutionII052 {
    //官方解法：回溯+set
    public int totalNQueens(int n) {
        //用于保证皇后位于不同列
        Set<Integer> columns = new HashSet<>();
        //用于保证皇后位于不同的右方向斜线
        Set<Integer> diagonals1 = new HashSet<>();
        //用于保证皇后位于不同的左方向斜线
        Set<Integer> diagonals2 = new HashSet<>();
        return backtrack(n, 0, columns, diagonals1, diagonals2);

    }

    private int backtrack(int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        //因为不同列不同行都只能存在一个皇后，所以从行开始遍历
        if (row == n) {
            return 1;
        } else {
            int count = 0;
            for (int i = 0; i < n; i++) {
                //因为不能存在同一列,所以如果出现同一列则跳过
                if (columns.contains(i)) {
                    continue;
                }
                //正方向斜向斜率 = row - column 比如（0,2） （3,5）
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                //反方向斜率 = row + column 比如(0,3) (1,2)
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                count += backtrack(n, row + 1, columns, diagonals1, diagonals2);
                //还原部分
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }

            return count;
        }
    }
}

