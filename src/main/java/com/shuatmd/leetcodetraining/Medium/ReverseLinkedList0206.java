package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.ListNode;
//206. 反转链表
//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。

public class ReverseLinkedList0206 {
    //官方解法：翻转链表的防线
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
           ListNode next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
        }
        return prev;

    }
}
