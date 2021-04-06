package com.leetcode.zzd.offer.easy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author: zhendong.Z
 * @date: 2021-01-29 上午10:19
 */
public class EasySolution {

    public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 数组中重复的数字
     * 找出数组中重复的数字。
     *
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     *
     * 示例 1：
     *
     * 输入：
     * [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     *
     * 限制：
     *
     * 2 <= n <= 100000
     */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int repeat = -1;
        for (int num : nums){
            if (!set.add(num)){
                repeat = num;
                break;
            }
        }
        return repeat;
    }

    /**
     * 替换空格
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     *
     * 示例 1：
     *
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     *
     * 限制：
     *
     * 0 <= s 的长度 <= 10000
     */
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * 从尾到头打印链表
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * 示例 1：
     *
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     *  
     * 限制：
     * 0 <= 链表长度 <= 10000
     * 思路：递归或者辅助栈，先入后出
     */
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }

    /**
     * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
     *
     *  
     *
     * 示例 1：
     *
     * 输入：
     * ["CQueue","appendTail","deleteHead","deleteHead"]
     * [[],[3],[],[]]
     * 输出：[null,null,3,-1]
     * 示例 2：
     *
     * 输入：
     * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
     * [[],[],[5],[2],[],[]]
     * 输出：[null,-1,null,null,5,2]
     *
     */


    /**
     * 青蛙跳台阶问题
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     *
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     * 示例 1：
     *
     * 输入：n = 2
     * 输出：2
     * 示例 2：
     *
     * 输入：n = 7
     * 输出：21
     * 示例 3：
     *
     * 输入：n = 0
     * 输出：1
     * 思路：动态规划，
     */
    public int numWays(int n) {
        int a = 1;
        int b = 1;
        int sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    /**
     * 旋转数组的最小数字
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
     *
     * 示例 1：
     *
     * 输入：[3,4,5,1,2]
     * 输出：1
     * 示例 2：
     *
     * 输入：[2,2,2,0,1]
     * 输出：0
     * 思路：二分查找
     */
    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }


    /**
     * 二进制中1的个数
     * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
     * 示例 1：
     *
     * 输入：00000000000000000000000000001011
     * 输出：3
     * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
     * 示例 2：
     *
     * 输入：00000000000000000000000010000000
     * 输出：1
     * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
     * 示例 3：
     *
     * 输入：11111111111111111111111111111101
     * 输出：31
     * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
     * 思路：位运算
     *
     */
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res ++;
            n &= n-1;
        }
        return res;
    }


}
