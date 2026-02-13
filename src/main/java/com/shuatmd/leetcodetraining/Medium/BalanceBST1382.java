package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.ArrayList;
import java.util.List;

//1382. 将二叉搜索树变平衡
//给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。如果有多种构造方法，请你返回任意一种。
//
//如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。
public class BalanceBST1382 {
    List<Integer> list = new ArrayList<>();

    //直接将当前treeNode记录在一个list中 然后对list做中序遍历就可以
    public TreeNode balanceBST(TreeNode root) {
        parseToList(root);
        return buildBalanceBST(list, 0, list.size() - 1);

    }

    private TreeNode buildBalanceBST(List<Integer> list, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildBalanceBST(list, left, mid - 1);
        root.right = buildBalanceBST(list, mid + 1, right);
        return root;


    }


    private void parseToList(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parseToList(root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            parseToList(root.right);
        }
    }
}
