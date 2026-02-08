package com.shuatmd.leetcodetraining.Medium;

import java.util.LinkedList;
import java.util.Queue;

//994. 腐烂的橘子
//在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
//
//值 0 代表空单元格；
//值 1 代表新鲜橘子；
//值 2 代表腐烂的橘子。
//每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
//
//返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
public class RottingOrange994 {
    int[] dx = new int[]{-1, 0, 1, 0};
    int[] dy = new int[]{0, -1, 0, 1};
    //手搓advance解法： 遍历的同时统计橘子的数量
    public int orangesRottingAdvanced(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        int cnt = 0;
        boolean shouldAdd = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                //同时统计新鲜橘子数量
                else if(grid[i][j] == 1){
                    cnt++;
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[1];
                int y = curr[0];
                for (int j = 0; j < 4; j++) {
                    int newX = x + dx[j];
                    int newY = y + dy[j];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newY][newX] == 1) {
                        grid[newY][newX] = 2;
                        queue.offer(new int[]{newY, newX});
                        shouldAdd = true;
                        //同步减少新鲜橘子的数量
                        cnt --;
                    }
                }
            }
            if (shouldAdd) {
                ans++;
                shouldAdd = false;
            }
        }
        return cnt == 0? ans:-1;
    }
    //手搓解法： bfs
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        boolean shouldAdd = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[1];
                int y = curr[0];
                for (int j = 0; j < 4; j++) {
                    int newX = x + dx[j];
                    int newY = y + dy[j];
                    if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newY][newX] == 1) {
                        grid[newY][newX] = 2;
                        queue.offer(new int[]{newY, newX});
                        shouldAdd = true;
                    }
                }
            }
            if (shouldAdd) {
                ans++;
                shouldAdd = false;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }
}
