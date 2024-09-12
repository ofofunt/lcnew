package com.shuatmd.leetcodetraining.Medium;

//剑指 Offer 36. 二叉搜索树与双向链表
//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
public class treeToDoublyList {
    Node head,pre;
    //打印中序遍历代码sample
    public void dfsSample(Node root){
        if(root == null){
            return;
        }
        //左侧优先
        dfsSample(root.left);
        //root
        System.out.println(root.val);
        //右最后
        dfsSample(root.right);
    }
    //解法: dfs递归整个树,同时设置数的左右链表引用
    public Node treeToDoublyList(Node root) {
        if(root == null){
            return null;
        }
        dfs(root);
        //手动设置最左和最右节点的关联
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node cur) {
        if(cur == null){
            return;
        }
        dfs(cur.left);
        //pre不为空,则将pre的右边设为cur
        if(pre != null){
            pre.right = cur;
        }
        //如果pre为空,则代表当前是最左节点，设为head
        else{
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;
}
