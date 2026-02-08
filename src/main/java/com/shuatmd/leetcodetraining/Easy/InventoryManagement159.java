package com.shuatmd.leetcodetraining.Easy;

import java.util.PriorityQueue;

//LCR 159. 库存管理 III
//仓库管理员以数组 stock 形式记录商品库存表，其中 stock[i] 表示对应商品库存余量。请返回库存余量最少的 cnt 个商品余量，返回 顺序不限。
public class InventoryManagement159 {
    //手搓解法1：大顶堆保留cnt个最小的
    public int[] inventoryManagement(int[] stock, int cnt) {
        if(cnt == 0){
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b -a);
        for (int i : stock) {
            if(queue.size() < cnt){
                queue.offer(i);
            }
            else{
                if(i < queue.peek()){
                    queue.poll();
                    queue.offer(i);
                }
            }

        }
        int[] res = new int[cnt];
        for (int i = 0; i < res.length; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
