package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.ListNode;

//19. 删除链表的倒数第 N 个结点
//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
public class DeleteNthFromEnd019 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        DeleteNthFromEnd019 test = new DeleteNthFromEnd019();
        test.removeNthFromEnd(listNode, 2);
    }

    //官方解法：引入dummy节点
    public ListNode removeNthFromEndOfficial(ListNode head, int n) {
        //引入dummy之后对于head头不用特殊处理
        ListNode dummy = new ListNode(0, head);
        ListNode lengthCount = dummy;
        int size = 0;
        while (lengthCount != null) {
            lengthCount = lengthCount.next;
            size++;
        }
        ListNode cur = dummy;
        for (int i = 1; i < size - n + 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;


    }

    //手搓解法：先算size 然后再n-k次
    //判断过于麻烦，而且对首位无法判断
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        ListNode temp2 = head;
        for (int i = 0; i < size - n - 1; i++) {
            temp2 = temp2.next;
        }
        if (n == size) {
            return head.next;
        }
        if (temp2.next != null && temp2.next.next != null) {
            temp2.next = temp2.next.next;
        } else {
            temp2.next = null;
        }
        return head;

    }
}
