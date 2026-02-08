package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTreePreOrderInOrder0105 {
    int[] preorder;
    int[] inorder;
    int rootIndex;
    Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        this.rootIndex = 0;
        int index = 0;
        for (int i : inorder) {
            indexMap.put(i, index);
            index++;
        }
        return helper(0, preorder.length - 1);

    }

    private TreeNode helper(int left, int right) {
        if (left > right) {
            return null;
        }
        int rootVal = preorder[rootIndex];
        TreeNode root = new TreeNode(rootVal);
        int index = indexMap.get(rootVal);
        rootIndex++;
        root.left = helper(left, index - 1);
        root.right = helper(index + 1, right);
        return root;
    }
}
