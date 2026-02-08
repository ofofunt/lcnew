package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//56. 合并区间
//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
//请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
public class MergeIntervals056 {
    //官方题解：排序+合并
    //通过排序后,合并的时候不需要考虑左边边框的变更
    //分为两种情况
    //1.当前2个数组不相交,则直接添加到结果中
    //2.当前2个数组部分重叠,取右边最大值更新
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            //如果当前list为空 或者当前list中最大的right小于目前数组的left 则直接添加当前数组到list中
            if(res.size() == 0 || res.get(res.size() - 1)[1] < left){
                res.add(new int[]{left,right});
            }
            //如果当前数组处于范围中,则将右边部分按照最大更新
            else{
                res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1], right);
            }
        }
        return res.toArray(new int[res.size()][2]);

    }
}
