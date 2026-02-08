package com.shuatmd.leetcodetraining.Hard;
//42. 接雨水
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
public class RainDropPickup42 {
    public static void main(String[] args) {
        RainDropPickup42 rainDrop = new RainDropPickup42();
        rainDrop.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
    //使用dp+横向切片来做
    //原理： 当前列能接到的雨水的量其实等于Math.min(左边最高的墙的高度，右边最高的墙的高度) - 自身高度
    //当遍历时 我们不断记录左边以及右边最高的墙
    public int trapOfficial(int[] height) {
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];
        //左右两端无法积水所以不用进入遍历
        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(height[i-1],max_left[i-1]);
        }
        for (int j = height.length - 2; j >= 0 ; j--) {
            max_right[j] = Math.max(height[j+1],max_right[j + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i],max_right[i]);
            if(height[i] < min){
                sum += min - height[i];
            }
        }
        return sum;
    }
    //手搓想法
    //从x = 0 开始遍历 遍历完成之后将所有height -1
    //遍历一次算一层的接雨水量，等到所有数字都小于0，则停止
    public int trap(int[] height) {
        int zeroCount = 0;
        int len = height.length;
        int res = 0;
        int leftIndex;
        //统计归0的个数 当归零个数=lenth的时候说明已经全部遍历完
        while(zeroCount < len){
            leftIndex = -1;
            for (int i = 0; i < len; i++) {
               if(height[i] == 0){
                   zeroCount++;
               }
               else if(height[i] > 0){
                   //第一次赋值需要初始化
                   if(leftIndex != -1){
                       res+= i - leftIndex - 1;
                   }
                   leftIndex = i;
               }
                height[i] --;
            }
        }
        return res;

    }
}
