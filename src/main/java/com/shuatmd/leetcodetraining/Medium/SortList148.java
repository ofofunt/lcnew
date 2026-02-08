package com.shuatmd.leetcodetraining.Medium;
//148. 排序链表
//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。

import com.shuatmd.leetcodetraining.DTO.ListNode;

//官方题解：递归 + 类似二分法
//不断从中间拆解链表 之后逐渐排序
public class SortList148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //快慢指针找到中间点
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //从slow处中断
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while(left!=null && right!=null){
            if(left.val<right.val){
                h.next = left;
                left = left.next;
            }
            else{
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }
}
