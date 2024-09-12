package com.shuatmd.leetcodetraining.Hard;

import java.util.LinkedList;
import java.util.Queue;

public class EncodeDecodeBinaryTree37 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {
        // Encodes a tree to a single string.
        //通过前序遍历来序列化，为了防止歧义，空节点需要输出null而不是跳过
        //利用queue来完成前序遍历,将node放入queue中开始循环,循环中将queue的左右节点也放入queue
        public String serialize(TreeNode root) {
            //如果root为空则直接返回空
            if (root == null) {
                return "[]";
            }
            StringBuilder res = new StringBuilder("[");
            //将当前的node放进queue中
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node != null) {
                    res.append(node.val + ",");
                    queue.add(node.left);
                    queue.add(node.right);
                }
                else{
                    res.append(null + ",");
                }
            }
            res.deleteCharAt(res.length()-1);
            res.append("]");
            return res.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.equals("[]")){
                return null;
            }
            String[] vals = data.substring(1, data.length()-1).split(",");
            TreeNode treeNode = new TreeNode(Integer.parseInt(vals[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(treeNode);
            int i = 1;
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(!vals[i].equals("null")){
                    node.left = new TreeNode(Integer.parseInt(vals[i]));
                    queue.add(node.left);
                }
                i++;

                if(!vals[i].equals("null")){
                    node.right = new TreeNode(Integer.parseInt(vals[i]));
                    queue.add(node.right);
                }
                i++;
            }
            return treeNode;
        }
    }
}
