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
}
