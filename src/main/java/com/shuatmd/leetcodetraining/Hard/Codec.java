package com.shuatmd.leetcodetraining.Hard;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//297. 二叉树的序列化与反序列化
//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
//
//请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
//
//提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
public class Codec {
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        res.append("[");
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                res.append("null,");
            } else {
                res.append(curr.val + ",");
                queue.offer(curr.left);
                queue.offer(curr.right);
            }
        }
        res.setLength(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.substring(1, data.length() - 1).split(",");
        TreeNode root = getNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode parent = root;
        boolean isLeft = true;
        for (int i = 0; i < nodes.length; i++) {
            TreeNode cur = getNode(nodes[i]);
            if (isLeft) {
                parent.left = cur;
            } else {
                parent.right = cur;
            }
            if (cur != null) {
                queue.offer(cur);
            }
            isLeft = !isLeft;
            if (isLeft) {
                parent = queue.poll();
            }
        }
        return root;

    }

    private TreeNode getNode(String node) {
        if (node.equals("null")) {
            return null;
        } else {
            return new TreeNode(Integer.valueOf(node));
        }
    }
}
