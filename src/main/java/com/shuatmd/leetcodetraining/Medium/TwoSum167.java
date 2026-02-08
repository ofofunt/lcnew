package com.shuatmd.leetcodetraining.Medium;

import java.util.HashMap;
import java.util.Map;

//167. 两数之和 II - 输入有序数组
//给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
//
//以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
//
//你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
//
//你所设计的解决方案必须只使用常量级的额外空间。
public class TwoSum167 {
    public static void main(String[] args) {
        TwoSum167 test = new TwoSum167();
        test.twoSum(new int[]{2, 7, 11, 15}, 9);
    }

    //手搓解法：双指针
    //一个从头开始 一个从尾开始
    //如果相加小于target 移动左指针
    //如果相加大于target 移动右指针
    public int[] twoSumTwoPointer(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length -1;
        int cur = 0;
        while(left < right){
             cur = numbers[left] + numbers[right];
             if(cur > target){
                 left++;
             } else if (cur < target) {
                 right--;
             } else if (cur == target) {
                 return new int[]{left,right};

             }
        }
        return new int[]{-1,-1};
    }


    //手搓解法：先把数组整体-target
    //然后循环找是否匹配
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> resMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            //先判断有没有 避免重复运算
            if (resMap.containsKey(numbers[i])) {
                return new int[]{resMap.get(numbers[i]) + 1, i + 1};
            }
            int left = target - numbers[i];
            resMap.put(left, i);
        }
        return new int[]{-1, -1};
    }
}
