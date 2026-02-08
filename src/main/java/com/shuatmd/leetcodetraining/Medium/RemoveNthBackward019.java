package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.ListNode;

//19. 删除链表的倒数第 N 个结点
//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

public class RemoveNthBackward019 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        RemoveNthBackward019 test = new RemoveNthBackward019();
        test.removeNthFromEndOneLoop(node,1);
    }
    //考虑一次遍历的解法:双指针
    //两个指针： first指针从原点开始 second指针先走n步 second到结尾的时候停住
    public ListNode removeNthFromEndOneLoop(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next =head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 0; i <= n; i++) {
            second = second.next;
        }
        while(second!=null){
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }
        //手搓解法：找到length 然后移除第n位
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        temp = head;
        if(n == length){
            return head.next;
        }
        for (int i = length - n - 1; i > 0; i--) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;


    }
}
