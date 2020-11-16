package com.leetcod.zzd.datastructures.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: zhendong.Z
 * @date: 2020-11-16 3:27 下午
 */
public class TreeSolution {

    /**
     * 树的遍历
     * 1、前序遍历
     * 前序遍历首先访问根节点，然后遍历左子树，最后遍历右子树。
     *
     * 2、中序遍历
     * 中序遍历是先遍历左子树，然后访问根节点，然后遍历右子树。
     *
     * 3、后序遍历
     * 后序遍历是先遍历左子树，然后遍历右子树，最后访问树的根节点。
     */

    /**
     * 定义二叉树
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 二叉树的前序遍历
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     *
     * 示例 1：
     * 输入：root = [1,null,2,3]
     * 输出：[1,2,3]
     *
     * 示例 2：
     * 输入：root = []
     * 输出：[]
     *
     * 示例 3：
     * 输入：root = [1]
     * 输出：[1]
     *
     * 示例 4：
     * 输入：root = [1,2]
     * 输出：[1,2]
     *
     * 示例 5：
     * 输入：root = [1,null,2]
     * 输出：[1,2]
     *  
     * 提示：
     * 树中节点数目在范围 [0, 100] 内
     * -100 <= Node.val <= 100
     *
     */

    /**
     * 递归
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }
    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    /**
     * 迭代
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }

}
