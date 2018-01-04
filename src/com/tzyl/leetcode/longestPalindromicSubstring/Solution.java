/**
 * 5. Longest Palindromic Substring
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * 
 * Example:
 * 
 * Input: "babad"
 * 
 * Output: "bab"
 * 
 * Note: "aba" is also a valid answer.
 * Example:
 * 
 * Input: "cbbd"
 * 
 * Output: "bb"
 */
package com.tzyl.leetcode.longestPalindromicSubstring;

public class Solution {
    public String longestPalindrome(String s) {
        String bestPalindrome = "";
        int length;
        int leftIndex;
        int rightIndex;
        for (int i = 0; i < s.length(); i++) {
            // Expand out from the character at index i as the centre of the palindrome.
            length = 1;
            leftIndex = i - 1;
            rightIndex = i + 1;
            while (leftIndex >= 0 && rightIndex < s.length() &&
                    s.charAt(leftIndex) == s.charAt(rightIndex)) {
                length += 2;
                leftIndex -= 1;
                rightIndex += 1;
            }
            if (length > bestPalindrome.length()) {
                int startIndex = i - length / 2;
                bestPalindrome = s.substring(startIndex, startIndex + length);
            }
            // Expand out from the gap just after the character in the index i.
            length = 0;
            leftIndex = i;
            rightIndex = i + 1;
            while (leftIndex >= 0 && rightIndex < s.length() &&
                    s.charAt(leftIndex) == s.charAt(rightIndex)) {
                length += 2;
                leftIndex -= 1;
                rightIndex += 1;
            }
            if (length > bestPalindrome.length()) {
                int startIndex = i + 1 - length / 2;
                bestPalindrome = s.substring(startIndex, startIndex + length);
            }
        }
        return bestPalindrome;
    }
}