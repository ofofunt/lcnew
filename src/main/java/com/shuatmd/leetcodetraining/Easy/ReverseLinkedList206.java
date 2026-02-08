package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.ListNode;

//206. 反转链表
//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
public class ReverseLinkedList206 {
    //官方解法 prev节点 + cur节点 cur节点永远指向prev节点
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;


    }
}
