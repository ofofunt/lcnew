package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.ListNode;

//61. 旋转链表
//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
public class RotateListNode051 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        RotateListNode051 test = new RotateListNode051();
        ListNode testNode = new ListNode(1);
        testNode.next = new ListNode(2);
        test.rotateRight(testNode,1);
    }
    //手搓解法1： 找到size 根据size切成两端然后拼接
    public ListNode rotateRight(ListNode head, int k) {
        ListNode length = head;
        int size = 0;
        while(length!=null){
            size++;
            length = length.next;
        }
        if(k == 0 || size == 0|| k%size == 0  || size == 1){
            return head;
        }
        int step = size - k%size;
        ListNode temp = head;
        ListNode curr = head;
        for (int i = 0; i < step -1; i++) {
            temp = temp.next;
        }
        ListNode left = temp.next;
        ListNode res = left;
        for (int i = 0; i < k%size - 1; i++) {
            left = left.next;
        }
        temp.next = null;
        ListNode right = curr;
        left.next = right;
        return res;

    }
}
