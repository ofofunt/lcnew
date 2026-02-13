package com.shuatmd.leetcodetraining.Medium;
//669. 修剪二叉搜索树
//给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树 不应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在 唯一的答案 。
//
//所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。

import com.shuatmd.leetcodetraining.DTO.TreeNode;

public class TrimBST669 {
    //迭代
    public TreeNode trimBSTIteration(TreeNode root, int low, int high) {
        //找到第一个满足要求的点 作为根节点
        while (root != null && (root.val < low || root.val > high)) {
            if (root.val < low) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        //如果没找到要记得返回null
        if (root == null) {
            return null;
        }
        //对左子树进行搜寻,如果出现小于边界的子树,用右子树代替
        for (TreeNode node = root; node.left != null; ) {
            if (node.left.val < low) {
                node.left = node.left.right;
            } else {
                node = node.left;
            }
        }
        //同理右子树
        for (TreeNode node = root; node.right != null; ) {
            if (node.right.val > high) {
                node.right = node.right.left;
            } else {
                node = node.right;
            }
        }
        return root;

    }

    //递归
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        //如果当前root小于区间,触发剪枝,向右寻找第一个符合要求的枝
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        //如果当前root大于区间,触发剪枝,向左寻找第一个符合要求的枝
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
