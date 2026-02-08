package com.shuatmd.leetcodetraining.Easy;

//27.移除元素
//给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
//
//假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
//
//更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
//返回 k。
public class RemoveElement0027 {
    public static void main(String[] args) {
        RemoveElement0027 test = new RemoveElement0027();
        test.removeElementNew(new int[]{3,2,2,3}, 3);
    }

    public int removeElementNew(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        for (int right = 0; right < nums.length ; right++) {
            if(nums[right]!= val){
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

    //手搓解法：双指针
    //注意数字可以任意顺序返回
    //有缺陷 没法展示后面几个数字
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length - 1;
        int left = 0;
        int right = 0;
        int count = 0;
        while (left < length - 1) {
            int cur = nums[left];
            if (cur == val) {
                while (nums[right] == val) {
                    right++;
                }
                nums[left] = nums[right];
            }
            count++;
            left++;
            right++;
        }
        return count;
    }
}
