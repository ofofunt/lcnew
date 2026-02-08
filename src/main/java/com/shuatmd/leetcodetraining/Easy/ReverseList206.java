package com.shuatmd.leetcodetraining.Easy;
//206. 反转链表

import com.shuatmd.leetcodetraining.DTO.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
public class ReverseList206 {
    //官方解法1：原地转 + 双指针
    public ListNode reverseListOfficial(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr !=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }
    //手搓解法1：辅助栈
    public ListNode reverseList(ListNode head) {
        ListNode res = new ListNode(0);
        ListNode temp = head;
        Deque<ListNode> nodeQueue = new ArrayDeque<>();
        while (temp != null) {
            nodeQueue.push(temp);
            temp = temp.next;
        }
        ListNode resTemp = res;
        for (ListNode listNode : nodeQueue) {
            resTemp.next = listNode;
            resTemp = resTemp.next;
        }
        //清空原来指针
        resTemp.next = null;
        return res.next;

    }
}
