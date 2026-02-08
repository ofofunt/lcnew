package com.shuatmd.leetcodetraining.Hard;
//23. 合并 K 个升序链表
//给你一个链表数组，每个链表都已经按升序排列。
//
//请你将所有链表合并到一个升序链表中，返回合并后的链表

import com.shuatmd.leetcodetraining.DTO.ListNode;

import java.util.PriorityQueue;

public class MergeAscendingLists023 {
    public class Status implements Comparable<Status> {
        int val;
        ListNode ptr;

        Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }

        public int compareTo(Status status2) {
            return this.val - status2.val;
        }
    }

    //官方解法2：优先队列
    public ListNode mergeKListsPriorityQueue(ListNode[] lists) {
        PriorityQueue<Status> queue = new PriorityQueue<>();
        //将所有listNode放入queue中
        //并且根据头节点的val从小到大排序
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(!queue.isEmpty()){
            //因为是最小堆,poll出来的一定是node.val最小的结果
            Status poll = queue.poll();
            tail.next = poll.ptr;
            tail = tail.next;
            //还需要把listNode下一位的整体放入queue中
            if(poll.ptr.next!=null){
                queue.offer(new Status(poll.ptr.next.val,poll.ptr.next));
            }
        }
        return head.next;
    }

    //普通解法：对于每个list中的每个链表,两两合并
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }

    //将2个链表升序合并
    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        //其中一方为空,则直接返回另一半
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        ListNode aPtr = a;
        ListNode bPtr = b;
        //循环终止条件，有一个指针为空
        while (aPtr != null && bPtr != null) {
            //对比当前指针的数值,然后赋值
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        //while停止后如果存在一端指针不为空,需要把后续的所有元素都加到链表中
        tail.next = aPtr != null ? aPtr : bPtr;
        return head.next;
    }
}
