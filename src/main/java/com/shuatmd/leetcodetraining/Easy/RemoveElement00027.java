package com.shuatmd.leetcodetraining.Easy;

//27. 移除元素
//给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
//
//假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
//
//更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
//返回 k。
public class RemoveElement00027 {
    public static void main(String[] args) {
        RemoveElement00027 test = new RemoveElement00027();
        test.removeElement(new int[]{3, 2, 2, 3}, 3);
    }

    //官方解法：双指针
    public int removeElementTwoPointer(int[] nums, int val) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if(nums[right]!=val){
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            while (right < nums.length && nums[right] == val) {
                right++;
            }
            if(right == nums.length){
                break;
            }
            nums[left] = nums[right];
            left++;
            right++;
        }
        return left;
    }
}
