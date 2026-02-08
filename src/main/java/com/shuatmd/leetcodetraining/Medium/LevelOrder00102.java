package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//102. 二叉树的层序遍历
//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
public class LevelOrder00102 {
    //手搓解法：queue + 遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Queue<TreeNode> nextLevel = new LinkedList<>();
            List<Integer> currLevel = new ArrayList<>();
            //可以换成for queue.size() 就不用重新用新的queue替换老queue了
            while(!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                currLevel.add(curr.val);
                if (curr.left != null) {
                    nextLevel.offer(curr.left);
                }
                if (curr.right != null) {
                    nextLevel.offer(curr.right);
                }
            }
            queue = nextLevel;
            res.add(currLevel);
        }
        return res;
    }
}
