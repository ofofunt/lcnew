package com.shuatmd.leetcodetraining.Easy;
//面试题 02.07. 链表相交
//给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。

import com.shuatmd.leetcodetraining.DTO.ListNode;

public class InterSectionListNode0207 {
    //官方解法：更便捷,因为长度一样 所以可以直接用null来作为终止
    ListNode getIntersectionNodeOfficial(ListNode headA, ListNode headB) {
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        //相等时则说明有intersection
        //都等于null则自动终止
        while (pointerA != pointerB) {
            pointerA = pointerA == null ? headB : pointerA.next;
            pointerB = pointerB == null ? headA : pointerB.next;
        }
        return pointerA;
    }

    //手搓解法：双节点 循环完直接指向对方点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        boolean shiftA = false;
        boolean shiftB = false;
        while (pointerA != null || pointerB != null) {
            if (pointerA == pointerB) {
                return pointerA;
            }
            if (pointerA == null && !shiftA) {
                pointerA = headB;
                shiftA = true;
            } else {
                pointerA = pointerA.next;
            }
            if (pointerB == null && !shiftB) {
                pointerB = headA;
                shiftB = true;
            } else {
                pointerB = pointerB.next;
            }
        }
        return null;
    }
}
