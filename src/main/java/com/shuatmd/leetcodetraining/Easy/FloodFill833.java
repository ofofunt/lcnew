package com.shuatmd.leetcodetraining.Easy;

import java.util.LinkedList;
import java.util.Queue;

//733.图像渲染
//有一幅以 m x n 的二维整数数组表示的图画 image ，其中 image[i][j] 表示该图画的像素值大小。你也被给予三个整数 sr ,  sc 和 color 。你应该从像素 image[sr][sc] 开始对图像进行上色 填充 。
//
//为了完成 上色工作：
//
//从初始像素开始，将其颜色改为 color。
//对初始坐标的 上下左右四个方向上 相邻且与初始像素的原始颜色同色的像素点执行相同操作。
//通过检查与初始像素的原始颜色相同的相邻像素并修改其颜色来继续 重复 此过程。
//当 没有 其它原始颜色的相邻像素时 停止 操作。
//最后返回经过上色渲染 修改 后的图像 。
public class FloodFill833 {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};
    //官方解法1： dfs
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int currColor = image[sr][sc];
        //如果颜色一样则不需要改动
        if(currColor == color){
            return image;
        }
        int n = image.length;
        int m = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr,sc});
        image[sr][sc] = color;
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            //上下左右轮流判断
            for (int i = 0; i < 4; i++) {
                int newX = cell[0] + dx[i];
                int newY = cell[1] + dy[i];
                //判断新的坐标是否超出限制,同时判断是否为同一颜色(注意判断的是原来的颜色)
                if(newX>=0 && newX < n && newY>=0 && newY < m && image[newX][newY] == currColor){
                    queue.offer(new int[]{newX,newY});
                    image[newX][newY] = color;
                }
            }
        }
        return image;

    }
}
