package com.shuatmd.leetcodetraining.Easy;

import java.util.HashSet;
import java.util.Set;

//编写一个算法来判断一个数 n 是不是快乐数。
//
//「快乐数」 定义为：
//
//对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
//然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
//如果这个过程 结果为 1，那么这个数就是快乐数。
//如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
public class HappyNumber292 { //202. 快乐数
    //快慢指针或者哈希表来判断，当出现循环的时候判断循环是否=1
    public boolean isHappy(int n) {
        //会出现3种情况
        //1.得到数字1
        //2.无限循环
        //3.变为无穷大
        //根据规律以及题目限制我们可以得知 即使13个9的结果也只有1053 所以不会出现无限大的
        Set<Integer> uniqueInt = new HashSet<>();
        while(n!=1 && !uniqueInt.contains(n)){
            uniqueInt.add(n);
            n = getNext(n);
        }
        return n == 1;

    }
    private int getNext(int n){
        int totalSum = 0;
        while(n > 0){
            int i = n % 10;
            n = n / 10;
            totalSum += i*i;
        }
        return totalSum;
    }
}
