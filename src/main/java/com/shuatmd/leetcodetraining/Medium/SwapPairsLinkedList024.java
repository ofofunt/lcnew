package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.ListNode;

//24. 两两交换链表中的节点
//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
public class SwapPairsLinkedList024 {
    //官方解法：用dummyHead + 2个指针
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        //排序顺序
        //dummy -> prev -> next -> next.next
        //dummy -> next
        //prev -> next.next
        //dummy -> next -> prev -> next.next
        //dummy 移到prev位置 重复操作
        while (temp.next != null && temp.next.next != null) {
            ListNode prev = temp.next;
            ListNode next = temp.next.next;
            temp.next = next;
            prev.next = next.next;
            next.next = prev;
            temp = prev;
        }
        return dummy.next;
    }
}
