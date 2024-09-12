package com.shuatmd.leetcodetraining.Medium;

//剑指 Offer 35. 复杂链表的复制
//请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
public class copyRandomList35 {
    //本体的难点主要是复制next的同时需要复制random节点
    //如果不需要复制random节点的复制方法
    public Node copyList(Node head) {
        Node cur = head;
        Node res = new Node(0);
        Node pre = res;
        while (cur != null) {
            Node node = new Node(cur.val);
            cur = cur.next;
            pre.next = node;
            pre = node;
        }
        return res.next;
    }

    //解法1：复制+拼接方法
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        //1.复制整个链表
        Node cur = head;
        while (cur != null) {
            //复制一个节点，并且和左右两个节点相连
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            //移动至下一个节点
            cur = tmp.next;
        }

        //2.构建新复制节点的random指向
        cur = head;
        while (cur != null) {
            //cur.next指向复制的节点,cur.random.next指向的是复制之后生成的节点
            //通过这种方式来给复制的节点设置好random节点
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        //3.拆分两个链表
        cur = head.next;
        Node pre = head;
        Node res = head.next;
        while (cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null;
        return res;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
