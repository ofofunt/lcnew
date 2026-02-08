package com.shuatmd.leetcodetraining.Medium;

import java.util.HashMap;
import java.util.Map;

//904. 水果成篮
//你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
//
//你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
//
//你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
//你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
//一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
//给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
public class FruitBasket904 {
    //手搓解法2： 还是滑动窗口
    public int totalFruitSlidingWindow(int[] fruits) {
        // ans: 最终结果，记录最大水果数量
        // fruit1和fruit2: 记录当前窗口中的两种水果类型
        // cnt1和cnt2: 记录当前窗口中两种水果的数量
        int ans = 0, fruit1 = -1, fruit2 = -1, cnt1 = 0, cnt2 = 0;

        // 使用滑动窗口，l是窗口左边界，r是窗口右边界
        for(int l = 0, r = 0; r < fruits.length; r++) {
            // 当前水果是第一种类型
            if(fruits[r] == fruit1) {
                cnt1++;
            }
            // 当前水果是第二种类型
            else if(fruits[r] == fruit2) {
                cnt2++;
            }
            // 当前水果是新类型，需要调整窗口
            else {
                // 移动左边界，直到窗口中只剩一种水果类型
                while(cnt1 != 0 && cnt2 != 0) {
                    if(fruits[l] == fruit1) {
                        cnt1--;
                    }
                    else if(fruits[l] == fruit2) {
                        cnt2--;
                    }
                    l++; // 左边界右移
                }
                // 如果第一种水果数量为0，替换为当前新水果
                if(cnt1 == 0) {
                    fruit1 = fruits[r];
                    cnt1 = 1;
                }
                // 否则替换第二种水果
                else {
                    fruit2 = fruits[r];
                    cnt2 = 1;
                }
            }
            // 更新最大水果数量
            ans = Math.max(ans, cnt1 + cnt2);
        }
        return ans;

    }

    //手搓解法： 滑动窗口
    //可能优化的地方：用map应该不够优
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        if (n == 0) {
            return 0;
        }
        int left = 0;
        int res = 1;
        Map<Integer, Integer> fruitCount = new HashMap<>();
        fruitCount.put(fruits[left], 1);
        for (int right = 1; right < n; right++) {
            while (fruitCount.size() >= 2 && !fruitCount.containsKey(fruits[right])) {
                fruitCount.put(fruits[left], fruitCount.get(fruits[left]) - 1);
                if (fruitCount.get(fruits[left]) == 0) {
                    fruitCount.remove(fruits[left]);
                }
                left++;
            }
            fruitCount.put(fruits[right], fruitCount.getOrDefault(fruits[right], 0) + 1);
            res = Math.max(res, right - left + 1);
        }
        return res;

    }
}
