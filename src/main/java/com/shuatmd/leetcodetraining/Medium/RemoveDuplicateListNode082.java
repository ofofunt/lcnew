package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.ListNode;

import java.util.HashSet;
import java.util.Set;

//82. 删除排序链表中的重复元素 II
//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
public class RemoveDuplicateListNode082 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(3);
        listNode.next.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next.next.next = new ListNode(5);
        RemoveDuplicateListNode082 test = new RemoveDuplicateListNode082();
        ListNode testNode2 = new ListNode(1, new ListNode(2));
        testNode2.next.next = new ListNode(2);
        test.deleteDuplicates2(testNode2);
    }

    //官方题解1:1次遍历
    //1次遍历,如果当cur.next 与 cur.next.next相等，记录下x的值同事删除所有记录
    public ListNode deleteDuplicatesOfficial(ListNode head) {
        ListNode dummyNode = new ListNode(999);
        dummyNode.next = head;
        ListNode curr = dummyNode;
        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                int x = curr.next.val;
                while (curr.next != null && curr.next.val == x) {
                    curr.next = curr.next.next;
                }
            } else {
                curr = curr.next;
            }
        }

        return dummyNode.next;
    }

    //尝试手搓2：因为要删除所有重复数字的节点，所以只有一个temp node应该不够
    //可以通过但是坑不少
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode temp = head;
        Set<Integer> set = new HashSet<>();
        set.add(temp.val);
        while (temp.next != null) {
            //加不了说明存在重复 需要判断
            if (!set.add(temp.next.val)) {
                temp.val = 999;
                temp.next.val = 999;
            }
            temp = temp.next;
        }
        ListNode temp2 = head;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (temp2 != null) {
            if (temp2.val != 999) {
                curr.next = new ListNode(temp2.val);
                curr = curr.next;
            }
            temp2 = temp2.next;
        }
        return dummy.next;
    }

    //手搓解法：set判断插入 如果重复则跳过这个节点
    //没注意题干，要所有重复节点。。
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> countSet = new HashSet<>();
        ListNode temp = head;
        countSet.add(temp.val);
        while (temp.next != null) {
            //add失败 说明出现重复
            if (!countSet.add(temp.next.val)) {
                if (temp.next != null && temp.next.next != null) {
                    temp.next = temp.next.next;
                } else {
                    temp.next = null;
                }
            } else {
                temp = temp.next;
            }
        }
        return head;

    }
}
