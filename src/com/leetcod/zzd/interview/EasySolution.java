package com.leetcod.zzd.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: zhendong.Z
 * @date: 2021-02-08 下午2:38
 */
public class EasySolution {

    /**
     * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
     *
     * 示例 1：
     *
     * 输入: s = "leetcode"
     * 输出: false
     * 示例 2：
     *
     * 输入: s = "abc"
     * 输出: true
     * 限制：
     *
     * 0 <= len(s) <= 100
     * 如果你不使用额外的数据结构，会很加分。
     */
    public boolean isUnique(String astr) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i<astr.length();i++){
            if (!set.add(astr.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
