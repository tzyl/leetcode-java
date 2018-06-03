/**
 * 44. Wildcard Matching
 *
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 * Example 1:
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input:
 * s = "aa"
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * Example 3:
 *
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 * Example 4:
 *
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 * Example 5:
 *
 * Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false

 */
package com.tzyl.leetcode.wildcardMatching;

public class Solution {
    // DP solution
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        // dp[i][j] true if there is a match for pattern p[j:] on string s[i:]
        boolean[][] dp = new boolean[m + 1][n + 1];
        // Empty pattern only matches empty string. Right side of dp array filled in now.
        dp[m][n] = true;
        // Fill in dp array from right to left, bottom to top using recurrence relation.
        // For appropriate indices in bounds:
        // dp[i][j] = dp[i][j + 1] or dp[i + 1][j] if p[j] = '*'
        //          = dp[i + 1][j + 1] if p[j] = '?'
        //          = dp[i + 1][j + 1] if p[j] != '*' or '?' and s[i] = p[j]
        for (int i = m; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (p.charAt(j) == '*') {
                    // Don't consume character or consume character and check '*' again
                    dp[i][j] = dp[i][j + 1] || (i < m && dp[i + 1][j]);
                } else if (p.charAt(j) == '?') {
                    // Consume character and the '?'.
                    dp[i][j] = i < m && dp[i + 1][j + 1];
                } else {
                    // Consume character if matches.
                    boolean currentCharacterMatches = (i < m && (s.charAt(i) == p.charAt(j)));
                    dp[i][j] = currentCharacterMatches && (i < m && dp[i + 1][j + 1]);
                }
            }
        }
        return dp[0][0];
    }
}
