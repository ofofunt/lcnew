package com.shuatmd.leetcodetraining.DTO;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode buildTree(List<Integer> inorder) {
        return buildTreeHelper(inorder, 0, inorder.size() - 1);
    }

    public static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < arr.length) {
            TreeNode current = queue.poll();

            if (arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }


    private static TreeNode buildTreeHelper(List<Integer> inorder, int left, int right) {
        if (left > right) {
            return null;
        }

        // 中序遍历中，根节点位于左右子树中间
        Integer rootVal = inorder.get(left);
        if (rootVal == null) {
            // 如果根节点是null，返回null表示空树
            return null;
        }
        TreeNode root = new TreeNode(rootVal);

        // 计算左子树的大小
        int leftSize = 0;
        for (int i = left + 1; i <= right; i++) {
            if (inorder.get(i).equals(rootVal)) {
                leftSize = i - left - 1;
                break;
            }
        }

        // 递归构建左子树和右子树
        root.left = buildTreeHelper(inorder, left + 1, left + leftSize);
        root.right = buildTreeHelper(inorder, left + leftSize + 1, right);

        return root;
    }
}
