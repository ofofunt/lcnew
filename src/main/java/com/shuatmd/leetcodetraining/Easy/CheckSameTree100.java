package com.shuatmd.leetcodetraining.Easy;
//100. 相同的树
//给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
//
//如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CheckSameTree100 {
    public static void main(String[] args) {
        TreeNode treeNodeQ = new TreeNode(1);
        treeNodeQ.left = new TreeNode(2);
        treeNodeQ.right = new TreeNode(3);
        TreeNode treeNodeP = treeNodeQ;
        CheckSameTree100 test = new CheckSameTree100();
        test.isSameTree(treeNodeP, treeNodeQ);
    }

    //官方解法：DFS强化版本
    //少判断，同事只用一个queue来做
    // 广度优先
    public boolean isSameTreeDFSAdvanced(TreeNode p, TreeNode q) {
        Queue<TreeNode> tmpQueue = new LinkedList<TreeNode>();
        tmpQueue.offer(p);
        tmpQueue.offer(q);
        while (!tmpQueue.isEmpty()) {
            p = tmpQueue.poll();
            q = tmpQueue.poll();
            if (p == null && q == null) {
                continue;
            }
            if ((p == null || q == null) || p.val != q.val) {
                return false;
            }
            tmpQueue.offer(p.left);
            tmpQueue.offer(q.left);

            tmpQueue.offer(p.right);
            tmpQueue.offer(q.right);
        }
        return true;
    }

    //官方解法：BFS判断
    public boolean isSameTreeBFS(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    //手搓解法：DFS判断：
    public boolean isSameTreeDFS(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.val != node2.val) {
                return false;
            }
            TreeNode left1 = node1.left, right1 = node1.right, left2 = node2.left, right2 = node2.right;
            if (left1 == null ^ left2 == null) {
                return false;
            }
            if (right1 == null ^ right2 == null) {
                return false;
            }
            if (left1 != null) {
                queue1.offer(left1);
            }
            if (right1 != null) {
                queue1.offer(right1);
            }
            if (left2 != null) {
                queue2.offer(left2);
            }
            if (right2 != null) {
                queue2.offer(right2);
            }
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }

    //手搓解法：DFS判断
    //写的太麻烦了 思索有没有办法简化下
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();
        queueQ.offer(q);
        queueP.offer(p);
        while (!queueP.isEmpty()) {
            int size = queueP.size();
            while (size > 0) {
                TreeNode pollP = queueP.poll();
                TreeNode pollQ = queueQ.poll();
                if (pollQ.val == pollP.val) {
                    if (pollP.left != null) {
                        if (pollQ.left == null) {
                            return false;
                        }
                        queueP.offer(pollP.left);
                        queueQ.offer(pollQ.left);
                    }
                    if (pollP.right != null) {
                        if (pollQ.right == null) {
                            return false;
                        }
                        queueP.offer(pollP.right);
                        queueQ.offer(pollQ.right);
                    }
                    if ((pollP.left == null && pollQ.left != null) || (pollP.right == null && pollQ.right != null)) {
                        return false;
                    }
                } else {
                    return false;
                }
                size--;
            }
        }
        return true;
    }
}
