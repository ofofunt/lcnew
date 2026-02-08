package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayList;
import java.util.List;

//39. 组合总和
//给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
//
//candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
//
//对于给定的输入，保证和为 target 的不同组合数少于 150 个。
//
//
public class CombinationOfSum039 {
    private List<List<Integer>> res;
    private List<Integer> currSolution;

    public static void main(String[] args) {
        CombinationOfSum039 test = new CombinationOfSum039();
        test.combinationSum(new int[]{2, 3, 6, 7}, 7);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.res = new ArrayList<>();
        this.currSolution = new ArrayList<>();
        int length = candidates.length;
        recur(candidates, 0, target, length);
        return res;
    }

    private void recur(int[] candidates, int start, int target, int length) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(currSolution));
            return;
        }

        for (int i = start; i < length; i++) {
            //如果剪枝 需要sort 否则会出错
//            //剪枝 如果比0小不需要遍历完后续的计算
//            if(target - candidates[i] < 0){
//                break;
//            }
            currSolution.add(candidates[i]);
            recur(candidates, i, target - candidates[i], length);
            currSolution.remove(currSolution.size() - 1);
        }


    }

}

