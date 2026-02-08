package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.ListNode;

//203. 移除链表元素
//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
public class RemoveElement203 {
    public static void main(String[] args) {
        ListNode nodes = ListNode.createList(new int[]{9,9,9,9});
        RemoveElement203 test = new RemoveElement203();
        test.removeElementsOficial(nodes,9);
    }
    //官方解法：更简单
    public ListNode removeElementsOficial(ListNode head, int val) {
        ListNode temp = new ListNode(0);
        ListNode res = temp;
        temp.next = head;
        while(temp.next!=null){
            if(temp.next.val == val){
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }
        return res.next;
    }
    //手搓解法
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = new ListNode(51);
        ListNode res = temp;
        temp.next = head;
        while (temp != null && temp.next != null) {
            ListNode prev = temp;
            ListNode next = temp.next;
            while (next != null && next.val == val) {
                next = next.next;
            }
            if (next == null) {
                prev.next = null;
                break;
            } else {
                prev.next = next;
            }
            temp = temp.next;
        }
        return res.next;

    }
}
