package com.shuatmd.leetcodetraining.Medium;

import java.util.LinkedList;
import java.util.Queue;

//542. 01 矩阵
//给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
//
//两个相邻元素间的距离为 1 。
public class Update01Matrix542 {
    int[] dx = new int[]{-1, 0, 1, 0};
    int[] dy = new int[]{0, -1, 0, 1};

    //官方解法1： 从0开始进行dfs直到所有图都被走完
    public int[][] updateMatrixOfficial(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] currCell = queue.poll();
            int i = currCell[0];
            int j = currCell[1];
            for (int k = 0; k < 4; k++) {
                int newI = i + dy[k];
                int newJ = j + dx[k];
                if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && !visited[newI][newJ]) {
                    res[newI][newJ] = res[i][j] + 1;
                    visited[newI][newJ] = true;
                    queue.offer(new int[]{newI,newJ});
                }
            }
        }
        return res;
    }

    //手搓解法1：循环+dfs
    //耗时太长并且没有优化
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] res = new int[m][n];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                } else {
                    Queue<int[]> queue = new LinkedList<>();
                    boolean[][] vis = new boolean[m][n];
                    queue.offer(new int[]{i, j});
                    vis[i][j] = true;
                    int dist = 0;
                    boolean found = false;

                    while (!queue.isEmpty() && !found) {
                        int size = queue.size();
                        // 这一层扩展距离 +1
                        for (int s = 0; s < size; s++) {
                            int[] cur = queue.poll();
                            int x = cur[0], y = cur[1];
                            if (mat[x][y] == 0) {
                                res[i][j] = dist;
                                found = true;
                                break;
                            }
                            for (int k = 0; k < 4; k++) {
                                int nx = x + dx[k], ny = y + dy[k];
                                if (nx >= 0 && ny >= 0 && nx < m && ny < n && !vis[nx][ny]) {
                                    vis[nx][ny] = true;
                                    queue.offer(new int[]{nx, ny});
                                }
                            }
                        }
                        dist++;
                    }
                }
            }
        }
        return res;
    }
}
