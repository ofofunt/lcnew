package com.shuatmd.leetcodetraining.Hard;

//135. 分发糖果
//n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
//
//你需要按照以下要求，给这些孩子分发糖果：
//
//每个孩子至少分配到 1 个糖果。
//相邻两个孩子评分更高的孩子会获得更多的糖果。
//请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
public class CandyDelivery135 {
    //官方解答：
    //使用贪心来做
    //两次遍历确保左右原则都满足
    //假设A小朋友与B小朋友相邻
    //原则A ratingA如果大于ratingB 则A一定要比B多一颗糖
    //原则B ratingB如果大于ratingA 则B一定要比A多一颗糖
    public int candy(int[] ratings) {
        int res = 0;
        int len = ratings.length;
        int[] left = new int[len];
        //进行第一遍从左往右的遍历，确保
        for (int i = 0; i < left.length; i++) {
            if(i>0 && ratings[i] > ratings[i-1]){
                left[i] = left[i-1] + 1;
            }
            //如果rating不高，则默认初始化为给一颗
            else {
                left[i] = 1;
            }

        }
        int[] right = new int[len];
        for (int i = right.length - 1; i >= 0; i--) {
            if(i < len - 1 && ratings[i] > ratings[i + 1]){
                right[i] = right[i + 1] + 1;
            }
            else{
                right[i] = 1;
            }
            res+=Math.max(left[i],right[i]);
        }
        return res;


    }
}
