/**
 * 10. Regular Expression Matching
 *
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */
package com.tzyl.leetcode.regularExpressionMatching;

class Solution {
    // DP solution
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        // Empty pattern only matches empty string. Right side of dp array filled in now.
        dp[m][n] = true;
        // Fill in dp array from right to left, bottom to top using recurrence relation.
        // For appropriate indices in bounds:
        // dp[i][j] = false if p[j] = '*'
        //          = dp[i][j + 2] or dp[i + 1][j] if p[j] != '*' and p[j + 1] = '*'
        //          = dp[i + 1][j + 1] if p[j] != '*' and p[j + 1] != '*'
        for (int i = m; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (p.charAt(j) == '*') {
                    dp[i][j] = false;
                } else {
                    boolean currentCharacterMatches = (i < m &&
                            (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
                    if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                        dp[i][j] = dp[i][j + 2] || (currentCharacterMatches && dp[i + 1][j]);
                    } else {
                        dp[i][j] = currentCharacterMatches && dp[i + 1][j + 1];
                    }
                }
            }
        }
        return dp[0][0];
    }

    // Returns true if there is a regex match for pattern p on the whole of string s.
    public boolean isMatchRecursive(String s, String p) {
        return isMatchRecursive(s, p, 0, 0);
    }

    // Returns true if there is a regex match for pattern p[j:] on the whole of string s[i:].
    private boolean isMatchRecursive(String s, String p, int i, int j) {
        // Empty pattern only matches empty string.
        if (j == p.length()) {
            return (i == s.length());
        }
        boolean currentCharacterMatches = (i < s.length() &&
                (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // We can either consume no characters or at least one.
            return isMatchRecursive(s, p, i, j + 2) || (currentCharacterMatches && isMatchRecursive(s, p, i + 1, j));
        }
        // No Kleene star so just check if current character matches and move along.
        return (currentCharacterMatches && isMatchRecursive(s, p, i + 1, j + 1));
    }
}