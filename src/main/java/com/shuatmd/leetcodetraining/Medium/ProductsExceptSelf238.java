package com.shuatmd.leetcodetraining.Medium;

public class ProductsExceptSelf238 {
    //官方解法：分为上下三角计算
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return new int[0];
        }
        int[] ans = new int[length];
        ans[0] = 1;
        int tmp = 1;
        //计算上半部分的三角
        for (int i = 1; i < length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        //计算下部分的三角
        for (int i = length - 2; i >= 0 ; i--) {
            tmp *= nums[i + 1];
            ans[i]  *= tmp;
        }
        return ans;
    }

}
