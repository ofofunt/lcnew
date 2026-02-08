package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.ListNode;

//86. 分隔链表
//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
//
//你应当 保留 两个分区中每个节点的初始相对位置。
public class SortListNode086 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(2);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(2);
        SortListNode086 test = new SortListNode086();
        test.partition(listNode,3);
    }
    public ListNode partition(ListNode head, int x) {
        ListNode dummyLeft = new ListNode(0);
        ListNode dummyRight = new ListNode(0);
        ListNode temp = head;
        ListNode left = dummyLeft;
        ListNode right = dummyRight;
        while(temp!=null){
            if(temp.val < x){
                left.next = new ListNode(temp.val);
                left = left.next;
            }
            else{
                right.next = new ListNode(temp.val);
                right = right.next;
            }
            temp = temp.next;
        }
        left.next = dummyRight.next;
        return dummyLeft.next;

    }
}
