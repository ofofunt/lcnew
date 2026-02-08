package com.shuatmd.leetcodetraining.Easy;
//206. 反转链表
//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
import com.shuatmd.leetcodetraining.DTO.ListNode;

public class ReverseLinkedList0206 {
    public static void main(String[] args) {
        ReverseLinkedList0206 test = new ReverseLinkedList0206();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        test.reverseList(head);

    }
    //顺序翻转
    public ListNode reverseList(ListNode head) {
       ListNode cur = head;
       ListNode pre = null;
       while(cur!=null){
           ListNode temp = cur.next;
           cur.next = pre;
           pre = cur;
           cur = temp;
       }
       return pre;

    }
}
