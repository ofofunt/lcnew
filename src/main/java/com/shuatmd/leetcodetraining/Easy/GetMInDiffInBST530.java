package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.TreeNode;
//530. 二叉搜索树的最小绝对差
//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
//
//差值是一个正数，其数值等于两值之差的绝对值。
public class GetMInDiffInBST530 {
    //运用二叉搜索树的规律，中序遍历 左 -> 根 -> 右一定是一个递增数列
    int pre;
    int ans;
    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;

    }

    private void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        dfs(root.left);
        if(pre == -1){
            pre = root.val;
        }
        else{
            ans = Math.min(ans,Math.abs(root.val - pre));
            pre = root.val;
        }
        dfs(root.right);
    }
}
