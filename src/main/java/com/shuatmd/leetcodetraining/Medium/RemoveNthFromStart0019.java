package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.ListNode;
//19. 删除链表的倒数第 N 个结点
//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
public class RemoveNthFromStart0019 {
    //双指针 一个先走 一个后走
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;
        ListNode end = dummy;
        for (int i = 0; i < n; i++) {
            end = end.next;
        }
        while(end.next!=null){
            start = start.next;
            end = end.next;
        }
        start.next = start.next.next;
        return dummy.next;

    }
}
