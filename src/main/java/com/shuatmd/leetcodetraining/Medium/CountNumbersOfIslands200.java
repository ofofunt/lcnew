package com.shuatmd.leetcodetraining.Medium;

import java.util.LinkedList;
import java.util.Queue;

//200. 岛屿数量
//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
//岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//
//此外，你可以假设该网格的四条边均被水包围。
public class CountNumbersOfIslands200 {
    public static void main(String[] args) {
        CountNumbersOfIslands200 test = new CountNumbersOfIslands200();
    }

    int[] dx = new int[]{-1, 0, 1, 0};
    int[] dy = new int[]{0, -1, 0, 1};

    //手搓解法：BFS + 计数
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 0 && n == 0) {
            return 0;
        }
        int res = 0;
        boolean[][] isVisited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //对于0或者已经访问过的节点，直接跳过
                if (isVisited[i][j] || grid[i][j] == '0') {
                    continue;
                }
                queue.offer(new int[]{i, j});
                isVisited[i][j] = true;
                while (!queue.isEmpty()) {
                    int[] curr = queue.poll();
                    int y = curr[0];
                    int x = curr[1];
                    for (int k = 0; k < 4; k++) {
                        int newY = y + dy[k];
                        int newX = x + dx[k];
                        if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newY][newX] == '1' && !isVisited[newY][newX]) {
                            queue.offer(new int[]{newY, newX});
                            isVisited[newY][newX] = true;
                        }
                    }
                }
                res++;
            }

        }
        return res;
    }
}
