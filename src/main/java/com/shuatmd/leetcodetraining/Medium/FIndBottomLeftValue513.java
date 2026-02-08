package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//513. 找树左下角的值
//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
//
//假设二叉树中至少有一个节点。
public class FIndBottomLeftValue513 {
    //遍历 但是先右后左 最后记录的一位一定是最左
    public int findBottomLeftValueReverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.right != null) {
                queue.add(cur.right);
            }
            if (cur.left != null) {
                queue.add(cur.left);
            }
            res = cur.val;
        }

        return res;
    }

    //遍历 记录最后一层 然后选第一位
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<TreeNode> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int count = queue.size();
            res = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                TreeNode cur = queue.poll();
                res.add(cur);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return res.get(0).val;
    }
}
