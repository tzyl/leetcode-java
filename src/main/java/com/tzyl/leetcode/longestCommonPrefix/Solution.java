/**
 * 14. Longest Common Prefix
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 */
package com.tzyl.leetcode.longestCommonPrefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String longestPrefix = "";
        String currentPrefix = "";
        while (isPrefix(currentPrefix, strs)) {
            longestPrefix = currentPrefix;
            if (longestPrefix.length() == strs[0].length()) break;
            currentPrefix = strs[0].substring(0, longestPrefix.length() + 1);
        }
        return longestPrefix;
    }

    public boolean isPrefix(String prefix, String[] strs) {
        for (String s : strs) {
            if (!s.startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }
}