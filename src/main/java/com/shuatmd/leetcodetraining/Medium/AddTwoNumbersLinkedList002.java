package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.ListNode;

//2. 两数相加
//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
//请你将两个数相加，并以相同形式返回一个表示和的链表。
//
//你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
public class AddTwoNumbersLinkedList002 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        AddTwoNumbersLinkedList002 test = new AddTwoNumbersLinkedList002();
        test.addTwoNumbers(l1, l2);
    }

    //手搓解法1：主位相加，记录进位
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return new ListNode();
        }
        ListNode resNode = new ListNode(0);
        ListNode tempNode = resNode;
        int plus = 0;
        while (l1 != null || l2 != null) {
            int sum = plus;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (sum >= 10) {
                sum %= 10;
                plus = 1;
            } else {
                plus = 0;
            }
            tempNode.next = new ListNode(sum);
            tempNode = tempNode.next;
        }
        if(plus == 1){
            tempNode.next = new ListNode(1);
        }
        return resNode.next;
    }
}
