package com.shuatmd.leetcodetraining.Easy;

import java.util.Arrays;

//136. 只出现一次的数字
//给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
//你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
public class SingleAppearanceNumber136 {
    public static void main(String[] args) {
        SingleAppearanceNumber136 test = new SingleAppearanceNumber136();
        test.singleNumber(new int[]{2,2,1});
    }
    //官方解法1：位运算 不停异或
    //答案是使用位运算。对于这道题，可使用异或运算 ⊕。异或运算有以下三个性质。
    //
    //任何数和 0 做异或运算，结果仍然是原来的数，即 a⊕0=a。
    //任何数和其自身做异或运算，结果是 0，即 a⊕a=0。
    //异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
    public int singleNumberOfficial(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;

    }
    //手搓解法1： sort之后进行运算 返回结果
    public int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                curr += nums[i];
            } else {
                curr -= nums[i];
            }
        }
        //直接返回结果
        return curr;
    }
    //手搓解法1： sort之后相减 取第一个不为0的
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                curr += nums[i];
            } else {
                curr -= nums[i];
                if(curr != 0){
                    return nums[i - 1];
                }
            }
        }
        //如果前面都通过 说明在最末尾
        return nums[nums.length - 1];
    }
}
