package com.shuatmd.leetcodetraining.Medium;
//235. 二叉搜索树的最近公共祖先

import com.shuatmd.leetcodetraining.DTO.TreeNode;

//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
//百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
public class FindLowestCommonAncestor235 {
    //手搓解法：递归+分类讨论
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while(true){
            //当pq都小于ancestor,说明两者都在root的左子树
            //左移root
            if(p.val < ancestor.val && q.val<ancestor.val){
              ancestor = ancestor.left;
            }
            //同理如果都大于则说明都在右子树
            else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            }
            //剩下的情况是如果分布在root的左右边.则root一定是他们的祖先
            //如果p q都在子树上而且p或者q等于root 则说明root也是他们的祖先
            else{
                break;
            }
        }
        return ancestor;
    }
}
