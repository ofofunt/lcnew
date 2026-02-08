package com.shuatmd.leetcodetraining.Easy;
//21. 合并两个有序链表
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

import com.shuatmd.leetcodetraining.DTO.ListNode;

public class CombineTwoSortedLinkedList021 {
    //手搓解法：遍历2个linked list
    //比大小逐一放入
    //如果其中一个链表还有空余 则将后续所有一起放入
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(0);
        ListNode temp = res;

        while (list1 != null && list2 != null) {
            if(list1.val <= list2.val){
                temp.next = list1;
                list1 = list1.next;
            }
            else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        //放入剩余的部分
        //如果两者都为null则放入空
        temp.next = list1==null? list2:list1;
        return res.next;
    }
}
