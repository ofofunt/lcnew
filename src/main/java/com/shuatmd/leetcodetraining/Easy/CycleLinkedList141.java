package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CycleLinkedList141 {
    //解法1： hashMap存
    //需要额外空间
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        Set<ListNode> nodeSet = new HashSet<>();
        while(head.next!=null){
            ListNode cur = head.next;
            if(!nodeSet.add(cur)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    //解法2：快慢指针
    //不需要额外空间
    public boolean hasCycleTwoPointer(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        fast = fast.next;
        while(slow!=fast){
            if(fast ==null || slow == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
