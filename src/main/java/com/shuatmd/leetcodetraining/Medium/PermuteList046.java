package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayList;
import java.util.List;

//46. 全排列
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
public class PermuteList046 {
    private List<Integer> nums;
    private List<List<Integer>> res;
    //手搓尝试：回溯+ 换位
    public List<List<Integer>> permute(int[] nums) {
        this.nums = new ArrayList<>();
        this.res = new ArrayList<>();
        for (int num : nums) {
            this.nums.add(num);
        }
        recur(0);
        return res;

    }

    private void recur(int i) {
        if(i == nums.size() - 1){
            res.add(new ArrayList<>(nums));
            return;
        }
        for (int j = i; j < nums.size(); j++) {
            //j从i到len-1变化，这些位置上的元素都可以当作第x个元素
            swap(j,i);//将第j个元素放在第i个位置，第i个位置被放在第j个位置，也就是被放在后面
            recur(i + 1);//一旦固定第i位，接下来去固定第i+1位
            swap(j,i);//取消固定，将原本的第i个元素放回来，方便其他元素固定，以避免重复
        }
    }

    private void swap(int a, int b){
        int tmp = nums.get(a);
        nums.set(a,nums.get(b));
        nums.set(b,tmp);
    }
}
