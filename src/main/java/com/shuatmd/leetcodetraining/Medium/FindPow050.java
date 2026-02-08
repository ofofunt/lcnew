package com.shuatmd.leetcodetraining.Medium;

public class FindPow050 {
    //官方解法：递归+快速幂
    //将n无限拆分并用分治的方式来算
    public double myPow(double x, int n) {
        long N = n;
        //如果n本身为负数 需要取对数
        return N>=0? quickMul(x,N):1.0/quickMul(x,-N);
    }

    private double quickMul(double x, long n) {
        //终止条件
        if(n == 0){
            return 1.0;
        }
        double y = quickMul(x,n/2);
        //如果当前的幂不为偶数 则还需要多乘以一个x
        return n%2 == 0? y*y : y*y*x;
    }
}
