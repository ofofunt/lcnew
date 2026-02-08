package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayList;
import java.util.List;

//79. 单词搜索
//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
//单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
public class SearchWordInMatrix079 {
    //手动解法 bfs
    int[] dx = new int[]{-1, 0, 1, 0};
    int[] dy = new int[]{0, -1, 0, 1};
    boolean res = false;

    public static void main(String[] args) {
        SearchWordInMatrix079 test = new SearchWordInMatrix079();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        test.exist(board, "ABCCED");
    }

    public boolean exist(char[][] board, String word) {
        if (board == null) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        if (m == 0 || n == 0) {
            return false;
        }
        boolean[][] isVisited = new boolean[m][n];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    list.add(new int[]{i, j});
                }
            }
        }
        for (int[] ints : list) {

            backlog(ints[0], ints[1], 1, word, isVisited, board);
        }


        return res;
    }

    private void backlog(int y, int x, int i, String word, boolean[][] isVisited, char[][] board) {
        if (i == word.length()) {
            res = true;
            return;
        }

        isVisited[y][x] = true;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < board[0].length && ny >= 0 && ny < board.length && !isVisited[ny][nx] && board[ny][nx] == word.charAt(i)) {
                isVisited[ny][nx] = true;
                backlog(ny, nx, i + 1, word, isVisited, board);
                isVisited[ny][nx] = false;
            }
        }
        isVisited[y][x] = false;

    }
}
