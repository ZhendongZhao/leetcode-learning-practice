package com.leetcode.zzd.offer.easy;

import java.util.HashSet;
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
     * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
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
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
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
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
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
     * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
     * 示例 1：
     *
     * 输入：00000000000000000000000000001011
     * 输出：3
     * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
     * 示例 2：
     *
     * 输入：00000000000000000000000010000000
     * 输出：1
     * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
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

    /**
     * 打印从1到最大的n位数
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
     *
     * 示例 1:
     *
     * 输入: n = 1
     * 输出: [1,2,3,4,5,6,7,8,9]
     * 说明：
     * 用返回一个整数列表来代替打印
     * n 为正整数
     * 思路：10^n-1最大值
     */
    public int[] printNumbers(int n) {
        int end = (int) (Math.pow(10, n) - 1);
        int[] res = new int[end];
        for (int i = 0; i < end; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    /**
     * 删除链表的节点
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     *
     * 返回删除后的链表的头节点。
     *
     * 注意：此题对比原题有改动
     *
     * 示例 1:
     *
     * 输入: head = [4,5,1,9], val = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     * 示例 2:
     *
     * 输入: head = [4,5,1,9], val = 1
     * 输出: [4,5,9]
     * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
     *  
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur != null) {
            pre.next = cur.next;
        }
        return head;
    }

    /**
     * 调整数组顺序使奇数位于偶数前面
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
     * 示例：
     *
     * 输入：nums = [1,2,3,4]
     * 输出：[1,3,2,4]
     * 注：[3,1,2,4] 也是正确的答案之一。
     * 思路：二进制，&判断，奇数最后一位一定是1，偶数最后一位一定是0
     */
    public int[] exchange(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        for (int num : nums) {
            if (num % 2 == 1) {
                result[left] = num;
                left++;
            } else {
                result[right] = num;
                right--;
            }

        }
        return result;
    }

    /**
     * 链表中倒数第k个节点
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     *
     * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 k = 2.
     *
     * 返回链表 4->5.
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


    /**
     * 合并两个排序的链表
     *
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     * 示例1：
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     * 限制：
     * 0 <= 链表长度 <= 1000
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0);
        ListNode cur = dum;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }

    /**
     * 二叉树的镜像
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     *
     * 例如输入：
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 镜像输出：
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     *
     * 示例 1：
     *
     * 输入：root = [4,2,7,1,3,6,9]
     * 输出：[4,7,2,9,6,3,1]
     *  
     * 限制：
     *
     * 0 <= 节点个数 <= 1000
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }




}
