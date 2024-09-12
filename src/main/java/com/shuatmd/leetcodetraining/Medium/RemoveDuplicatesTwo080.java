package com.shuatmd.leetcodetraining.Medium;
//80. 删除有序数组中的重复项 II
//给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
//
//不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
public class RemoveDuplicatesTwo080 {
    //官方解法1：
    //更优雅的双指针
    //因为题目中说了是有序数列 所以在比较的时候并不需要count 只需要比较一个数和他-2位置的数是否相等就行
    //举例 1 1 3 3 5 此时我们判断第四位的3是否应该插入的时候 不需要关注是否和前一位的3的关系 只需要看3 不等于第二位的1 即可插入
    public int removeDuplicatesOfficial(int[] nums) {
        int n = nums.length;
        if(n < 2){
            return n;
        }
        //左右指针都从第三位开始 因为前两位即使相等也需要保留
        int left = 2;
        for (int right = 2; right < nums.length; right++) {
            if(nums[right] != nums[left - 2]){
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
    //手搓解法1：双指针 + count判断
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }
        int left = 0;
        int count = 1;
        for (int right = 1; right < nums.length; right++) {
            if(nums[right] == nums[left] && count < 2){
                count ++;
                //需要注意的点 因为left从0开始 所以赋值前需要先右移一位
                left ++;
                nums[left] = nums[right];
            } else if (nums[right] != nums[left]) {
                count = 1;
                //需要注意的点 因为left从0开始 所以赋值前需要先右移一位
                left++;
                nums[left] = nums[right];
            }
        }
        //需要注意的点 最后返回结果需要+1 因为left是index 返回的是length
        return left + 1;

    }

    public static void main(String[] args) {
        RemoveDuplicatesTwo080 remove = new RemoveDuplicatesTwo080();
        remove.removeDuplicates(new int[]{1,1,1,2,2,3});
    }
}
