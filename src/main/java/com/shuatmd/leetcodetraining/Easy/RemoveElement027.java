package com.shuatmd.leetcodetraining.Easy;
//27. 移除元素
//给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
//
//假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
//
//更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
//返回 k。
public class RemoveElement027 {
    //官方解法2：优化双指针
    //因为结果中nums不需要正确的排序
    //所以双指针可以一个指向array头 一个指向array尾部
    public int removeElementOfficial2(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            if(nums[left] == val){
                nums[left] = nums[right];
                right --;
            }
            else{
                left++;
            }
        }
        return left;
    }

    //官方解法1：双指针解决
    public int removeElementOfficial(int[] nums, int val) {
        //使用双指针 一个指针left记录多少个数字满足要求
        //另一个指针right记录当前遍历的index
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            //因为不需要考虑nums k位之后的元素,所以符合要求的数字直接放入nums前面即可
            if(nums[right] != val){
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
    //手搓解法1: 循环 在循环中进行删除以及复制
    //并不能解决问题
    public int removeElement(int[] nums, int val) {
        int res = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if(cur == val) {
                res++;
            }

        }
        return res;
    }
}
