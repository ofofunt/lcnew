package com.shuatmd.leetcodetraining.Easy;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

import java.util.*;

//257. 二叉树的所有路径
//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
//
//叶子节点 是指没有子节点的节点。
public class BinaryTreeAllPaths257 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.buildTree(new Integer[]{1,2,3,null,5});
        BinaryTreeAllPaths257 test = new BinaryTreeAllPaths257();
        test.binaryTreePaths(treeNode);

    }
    //递归解法：
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        constructPath(root,"",res);
        return res;
    }

    private void constructPath(TreeNode root, String path, List<String> res) {
        if(root !=null){
            StringBuffer sb = new StringBuffer(path);
            sb.append(root.val);
            if(root.left==null && root.right ==null){
                res.add(sb.toString());
            }
            else{
                sb.append("->");
                constructPath(root.left,sb.toString(),res);
                constructPath(root.right,sb.toString(),res);
            }
        }
    }
    //遍历解法
    public List<String> binaryTreePathsFor(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<String> res= new ArrayList<>();
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();
        treeNodeQueue.offer(root);
        pathQueue.offer(String.valueOf(root.val));
        while(!treeNodeQueue.isEmpty()){
            TreeNode curr = treeNodeQueue.poll();
            String currStr = pathQueue.poll();
            if(curr.left == null && curr.right == null){
                res.add(currStr);
            }
            else{
                if(curr.left!=null){
                    treeNodeQueue.offer(curr.left);
                    pathQueue.offer(new StringBuilder(currStr).append("->").append(String.valueOf(curr.left.val)).toString());
                }
                if(curr.right!=null){
                    treeNodeQueue.offer(curr.right);
                    pathQueue.offer(new StringBuilder(currStr).append("->").append(String.valueOf(curr.right.val)).toString());
                }
            }
        }
        return res;
        

    }
}
