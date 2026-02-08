package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.*;

//199. 二叉树的右视图
//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
public class RightSideViewBinaryTree199 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1, 2, 3, null, 5, null, 4});
        RightSideViewBinaryTree199 test = new RightSideViewBinaryTree199();
        test.rightSideView(treeNode);
    }

    //官方解法：DFS+记录深度
    //最后通过遍历map来查询最右的结果
    public List<Integer> rightSideViewDFS(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Map<Integer,Integer> rightMostValueAtDepth = new HashMap<>();
        int max_depth = -1;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        nodeQueue.offer(root);
        depthQueue.offer(0);
        while(!nodeQueue.isEmpty()){
            TreeNode node = nodeQueue.poll();
            Integer depth = depthQueue.poll();
            if(node !=null){
                max_depth = Math.max(max_depth,depth);
                //记录每个depth最右的val
                rightMostValueAtDepth.put(depth,node.val);
                nodeQueue.offer(node.left);
                nodeQueue.offer(node.right);
                depthQueue.offer(depth + 1);
                depthQueue.offer(depth + 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        //轮询map 取出每个depth最右的值
        for (int i = 0; i <= max_depth; i++) {
            res.add(rightMostValueAtDepth.get(i));
        }
        return res;
    }

    //手搓想法1：DFS然后每层返回最右边的node
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        res.add(root.val);
        while (!queue.isEmpty()) {
            Deque<TreeNode> currQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    currQueue.offer(poll.left);
                }
                if (poll.right != null) {
                    currQueue.offer(poll.right);
                }
            }
            if(!currQueue.isEmpty()) {
                res.add(currQueue.getLast().val);
            }
            queue = currQueue;
        }
        return res;
    }
}
