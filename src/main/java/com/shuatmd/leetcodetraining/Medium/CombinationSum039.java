package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum039 {
    //官方题解：回溯
    //两个小细节：
    //sort当前数组方便剪枝
    //start作为起点遍历,方便后续剪枝

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> state = new ArrayList<>();
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        backtrack(state, target, candidates,start,res);
        return res;
    }

    private void backtrack(List<Integer> state, int target, int[] candidates, int start, List<List<Integer>> res) {
        if(target == 0){
            res.add(new ArrayList<>(state));
            return;
        }

        //从start开始剪枝，避免重复子支
        for (int i = start; i < candidates.length; i++) {
            //因为已经进行过排序，如果当前和大于target 则之后所有和都大于target 可以剪枝
            if(target - candidates[i] < 0){
                break;
            }
            state.add(candidates[i]);
            //传入i作为起点 剪枝重复节点
            backtrack(state,target-candidates[i],candidates,i,res);
            //回溯修改
            state.remove(state.size()- 1);
        }
    }
}
