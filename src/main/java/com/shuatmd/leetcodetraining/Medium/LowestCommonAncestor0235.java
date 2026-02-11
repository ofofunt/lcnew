package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.DTO.TreeNode;

//235. 二叉搜索树的最近公共祖先
//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
//
//百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//
//例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
public class LowestCommonAncestor0235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        int rv = root.val;
        int pv = p.val;
        int qv = q.val;
        if(pv < rv && qv < rv){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(pv>rv && qv > rv){
            return lowestCommonAncestor(root.right,p,q);
        }
        else{
            return root;
        }
    }
}
