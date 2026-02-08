package com.shuatmd.leetcodetraining.Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

//502. IPO
//假设 力扣（LeetCode）即将开始 IPO 。为了以更高的价格将股票卖给风险投资公司，力扣 希望在 IPO 之前开展一些项目以增加其资本。 由于资源有限，它只能在 IPO 之前完成最多 k 个不同的项目。帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。
//
//给你 n 个项目。对于每个项目 i ，它都有一个纯利润 profits[i] ，和启动该项目需要的最小资本 capital[i] 。
//
//最初，你的资本为 w 。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
//
//总而言之，从给定项目中选择 最多 k 个不同项目的列表，以 最大化最终资本 ，并输出最终可获得的最多资本。
//
//答案保证在 32 位有符号整数范围内。
public class IPOProblem502 {
    //官方解法1：贪心法
    //根据 profits 和 capital 预处理出总的任务集合二元组，并根据「启动资金」进行升序排序；
    //
    //每次决策前，将所有的启动资金不超过 w 的任务加入优先队列（根据利润排序的大根堆），然后从优先队列（根据利润排序的大根堆），将利润累加到 w；
    //
    //循环步骤 2，直到达到 k 个任务，或者队列为空（当前资金不足以选任何任务）。
    //
    //作者：宫水三叶
    //链接：https://leetcode.cn/problems/ipo/solutions/985099/gong-shui-san-xie-noxiang-xin-ke-xue-xi-fk1ra/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[]{capital[i], profits[i]});
        }
        //按照需求的资本大小进行排序 而不是profit
        Collections.sort(list, (a, b) -> a[0] - b[0]);
        //新建一个最大堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        //外置i 用于防止单个项目被多次统计
        int i = 0;
        while (k-- > 0) {
            //将满足资本w需求的项目放入最大堆中
            while (i < n && list.get(i)[0] <= w) {
                queue.add(list.get(i++)[1]);
            }
            if (queue.isEmpty()) {
                break;
            }
            //用最大堆排序后,poll出来的就是满足当前w且profit最高的项目
            w += queue.poll();
        }

        return w;
    }
}
