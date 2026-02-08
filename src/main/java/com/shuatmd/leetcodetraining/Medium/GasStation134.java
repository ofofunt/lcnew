package com.shuatmd.leetcodetraining.Medium;

import java.util.Arrays;

//134. 加油站
//在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
//
//你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
//
//给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的
public class GasStation134 {
    public static void main(String[] args) {
        int[] gas = new int[]{5,8,2,8};
        int[] cost =new int[]{6,5,6,6};
        GasStation134 gasStation = new GasStation134();
        int res = gasStation.canCompleteCircuitHand(gas,cost);
    }
    //通过图论去解
    //https://leetcode.cn/problems/gas-station/solutions/54278/shi-yong-tu-de-si-xiang-fen-xi-gai-wen-ti-by-cyayc/?envType=study-plan-v2&envId=top-interview-150
    //画出油量的图，无论从哪出发都不会改变整体形状，只会改变y的值
    //需要做的就是将实时油量的最低点提到y轴之上，这样就可以保证全程油量都是大于等于0
    public int canCompleteCircuitGraph(int[] gas, int[] cost) {
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            spare += gas[i] - cost[i];
            if(spare < minSpare){
                minSpare = spare;
                minIndex = i;
            }
        }
        //index+1可能超过总长 所以需要求余数
        return spare <0? -1:(minIndex+1)%gas.length;
    }
    //手搓尝试
    //找到这个array中最长和的部分，作为起点
    //改进点 1. 可以在求diff的时候直接把消耗和补给的和算完 如果消耗大于补给 肯定无法完成一圈
    //改进点 2. 不需要找array中最长和部分，只需要找到从哪个点开始后续的和最大就行
    public int canCompleteCircuitHand(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            diff[i] = gas[i] - cost[i];
            sum += diff[i];
        }
        if(sum < 0){
            return -1;
        }
        int max = 0;
        int cur = 0;
        int maxIndex = 0;
        for (int i = 0; i < diff.length; i++) {
            cur-=diff[i];
            if(cur > max){
                max = cur;
                maxIndex = i + 1;
            }
        }
        return maxIndex;
    }
}
