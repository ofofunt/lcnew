package com.shuatmd.leetcodetraining.Medium;
//75. 颜色分类
//给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
//我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//
//必须在不使用库内置的 sort 函数的情况下解决这个问题。
public class ColorSorting075 {
    public static void main(String[] args) {
        ColorSorting075 test = new ColorSorting075();
        test.sortColors(new int[]{2,0,2,1,1,0});
    }
    //官方解法：双循环 单指针
    //第一次循环的时候将所有0移到最左边
    //第二次循环的时候将所有1移到0的后面
    //如果不考虑原地解决,可以直接统计个数之后重排一个新的数组
    public void sortColors(int[] nums) {
        int ptrIndex = 0;
        int len = nums.length;
        if(len == 0){
            return;
        }
        for (int i = 0; i < len; i++) {
            if(nums[i] == 0){
                int tmp = nums[ptrIndex];
                nums[ptrIndex] = 0;
                nums[i] = tmp;
                ptrIndex++;
            }
        }
        for (int i = ptrIndex; i < len ; i++) {
            if(nums[i] == 1){
                int tmp = nums[ptrIndex];
                nums[ptrIndex] = 1;
                nums[i] = tmp;
                ptrIndex++;
            }
        }
        return;
    }
}
