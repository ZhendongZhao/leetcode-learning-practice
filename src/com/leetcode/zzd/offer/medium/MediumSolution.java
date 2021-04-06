package com.leetcode.zzd.offer.medium;

import com.leetcode.zzd.offer.easy.EasySolution;

/**
 * @author: zhendong.Z
 * @date: 2021-02-20 下午4:44
 */
public class MediumSolution {

    /**
     * 二维数组中的查找
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * 示例:
     * 现有矩阵 matrix 如下：
     *
     * [
     *   [1,   4,  7, 11, 15],
     *   [2,   5,  8, 12, 19],
     *   [3,   6,  9, 16, 22],
     *   [10, 13, 14, 17, 24],
     *   [18, 21, 23, 26, 30]
     * ]
     * 给定 target = 5，返回 true。
     *
     * 给定 target = 20，返回 false。
     *
     * 限制：
     *
     * 0 <= n <= 1000
     *
     * 0 <= m <= 1000
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int row = 0;
        int column = columns -1;
        while (row < rows && column >= 0){
            int num = matrix[row][column];
            if (num == target){
                return true;
            }else if (num > target){
                column--;
            }else {
                row++;
            }
        }
        return false;
    }

    /**
     * 重建二叉树
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如，给出
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 限制：
     *
     * 0 <= 节点个数 <= 5000
     * 思路：
     * 二叉树前序遍历的顺序为：先遍历根节点；随后递归地遍历左子树；最后递归地遍历右子树。
     *
     * 二叉树中序遍历的顺序为：先递归地遍历左子树；随后遍历根节点；最后递归地遍历右子树。
     */
    public EasySolution.TreeNode buildTree(int[] preorder, int[] inorder) {

    }


}
