package com.leetcod.zzd.datastructures.string;

/**
 * @author: zhendong.Z
 * @date: 2020-09-11 10:14 上午
 */
public class StringSolution {

    /**
     * 最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1:
     *
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     *
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     *
     * 所有输入只包含小写字母 a-z 。
     *
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 0; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    /**
     * 最长回文子串
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *
     * 示例 1：
     *
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     *
     * 输入: "cbbd"
     * 输出: "bb"
     *
     */
    public String longestPalindrome(String s) {
        return null;
    }

    /**
     * 翻转字符串里的单词
     * 给定一个字符串，逐个翻转字符串中的每个单词。
     *
     * 说明：
     *
     * 无空格字符构成一个 单词 。
     * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     *  
     *
     * 示例 1：
     *
     * 输入："the sky is blue"
     * 输出："blue is sky the"
     * 示例 2：
     *
     * 输入："  hello world!  "
     * 输出："world! hello"
     * 解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     * 示例 3：
     *
     * 输入："a good   example"
     * 输出："example good a"
     * 解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     * 示例 4：
     *
     * 输入：s = "  Bob    Loves  Alice   "
     * 输出："Alice Loves Bob"
     * 示例 5：
     *
     * 输入：s = "Alice does not even like bob"
     * 输出："bob like even not does Alice"
     *  
     *
     * 提示：
     *
     * 1 <= s.length <= 104
     * s 包含英文大小写字母、数字和空格 ' '
     * s 中 至少存在一个 单词
     *
     * 双指针
     * 算法解析：
     * 倒序遍历字符串 ss ，记录单词左右索引边界 ii , jj ；
     * 每确定一个单词的边界，则将其添加至单词列表 resres ；
     * 最终，将单词列表拼接为字符串，并返回即可。
     * 复杂度分析：
     * 时间复杂度 O(N)： 其中 N 为字符串 s 的长度，线性遍历字符串。
     * 空间复杂度 O(N) ： 新建的 StringBuilder(Java) 中的字符串总长度 ≤N ，占用 O(N) 大小的额外空间。
     *
     */
    public String reverseWords(String s) {
        // 删除首尾空格
        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while(i >= 0) {
            while(i >= 0 && s.charAt(i) != ' ') {
                i--; // 搜索首个空格
            }
            // 添加单词
            res.append(s.substring(i + 1, j + 1)).append(" ");
            while(i >= 0 && s.charAt(i) == ' ') {
                // 跳过单词间空格
                i--;
            }
            // j 指向下个单词的尾字符
            j = i;
        }
        // 转化为字符串并返回
        return res.toString().trim();

    }

    /**
     * 反转字符串
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     *
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     *
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     *
     * 示例 1：
     *
     * 输入：["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     * 示例 2：
     *
     * 输入：["H","a","n","n","a","h"]
     * 输出：["h","a","n","n","a","H"]
     *
     */
    public void reverseString(char[] s) {
        int n = s.length;
        for (int left = 0,right = n-1; left <right; ++left, --right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }
}
