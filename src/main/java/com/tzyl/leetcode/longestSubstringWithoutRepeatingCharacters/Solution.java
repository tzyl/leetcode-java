/**
 * 3. Longest Substring Without Repeating Characters
 *
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Examples:
 * 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * 
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
package com.tzyl.leetcode.longestSubstringWithoutRepeatingCharacters;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int j = 0;
        boolean[] inSubstring = new boolean[256];
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && !inSubstring[s.charAt(j)]) {
                inSubstring[s.charAt(j)] = true;
                j++;
            }
            if ((j - i) > longest) longest = j - i;
            inSubstring[s.charAt(i)] = false;
        }
        return longest;
    }
}