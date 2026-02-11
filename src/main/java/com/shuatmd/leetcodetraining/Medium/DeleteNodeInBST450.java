package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

//450. 删除二叉搜索树中的节点
//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
//
//一般来说，删除节点可分为两个步骤：
//
//首先找到需要删除的节点；
//如果找到了，删除它。
public class DeleteNodeInBST450 {
    //递归 但是root变化版本
    public TreeNode deleteNodeIteration(TreeNode root, int key) {
        //前面逻辑保持一致
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        if (key == root.val) {
            //前三种情况保持不变
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            //左右子树都存在的情况发生变化
            //还是一样找到右子树的最左子树
            //因为最左子树一定没有自己的左子树,所以可以把root的左子树链接到继承数的左子树
            //然后选择要删除的root的右边第一个节点替换当前root
            else{
                TreeNode node = root.right;
                while(node.left!=null){
                    node = node.left;
                }
                node.left = root.left;
                root = root.right;
            }
        }
        return root;
    }

    //递归： 首先递归找到当前key对应的node
    //找到之后分情况讨论：
    //1.如果root没有左右子树,则直接删除
    //2.如果root只有左右子树之一,直接用左右子树替换
    //3.如果root左右子树都有，需要找到root右子树中的最小节点来继承(保持root不变)
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        //找到root 开始执行删除操作
        if (root.val == key) {
            //如果root没有左右子树,直接删除
            if (root.left == null && root.right == null) {
                return null;
            }
            //只有左子树，直接使用左子树
            if (root.right == null) {
                return root.left;
            }
            //只有右子树，直接使用右子树
            if (root.left == null) {
                return root.right;
            }
            //左右子树都有,需要找到右子树中的最左的来继承
            TreeNode successor = root.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            root.right = deleteNode(root.right, successor.val);
            successor.right = root.right;
            successor.left = root.left;
            return successor;
        }
        return root;
    }
}
