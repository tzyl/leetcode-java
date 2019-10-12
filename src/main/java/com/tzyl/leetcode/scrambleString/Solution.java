/**
 * 87. Scramble String
 * <p>
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * <p>
 * Below is one possible representation of s1 = "great":
 * <p>
 * <p>
 * great
 * /    \
 * gr    eat
 * / \    /  \
 * g   r  e   at
 * / \
 * a   t
 * <p>
 * <p>
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * <p>
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 * <p>
 * <p>
 * rgeat
 * /    \
 * rg    eat
 * / \    /  \
 * r   g  e   at
 * / \
 * a   t
 * <p>
 * <p>
 * We say that "rgeat" is a scrambled string of "great".
 * <p>
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 * <p>
 * <p>
 * rgtae
 * /    \
 * rg    tae
 * / \    /  \
 * r   g  ta  e
 * / \
 * t   a
 * <p>
 * <p>
 * We say that "rgtae" is a scrambled string of "great".
 * <p>
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s1 = "great", s2 = "rgeat"
 * Output: true
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s1 = "abcde", s2 = "caebd"
 * Output: false
 */
package com.tzyl.leetcode.scrambleString;

public class Solution {

    /**
     * O(n^4) DP solution.
     */
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int n = s1.length();

        if (n == 0) {
            return true;
        }

        // Let 0 <= i < n, 0 <= j < n, 1 <= k <= n.
        // Let dp[i][j][k] = true if:
        //   s1[i],..., s1[i + k - 1] is a scramble of s2[j],...,s2[j + k - 1]
        //
        // For k = 1 we have:
        //   dp[i][j][1] = true if s1[i] == s2[j]
        //
        // For 2 <= k <= n we have:
        //   dp[i][j][k] = true if there exists some 1 <= q < k such that:
        //     (dp[i][j][q] = true AND dp[i + q][j + q][k - q] = true)
        //     OR
        //     (dp[i][j + k - q][q] = true AND dp[i + q][j][k - q] = true)
        //
        //   i.e. for all possible binary tree splits we choose to either swap or not swap.
        boolean[][][] dp = new boolean[n][n][n + 1];
        for (int k = 1; k <= n; k++) {
            for (int i = 0; i + k <= n; i++) {
                for (int j = 0; j + k <= n; j++) {
                    if (k == 1) {
                        dp[i][j][k] = s1.charAt(i) == s2.charAt(j);
                        continue;
                    }
                    for (int q = 1; q < k; q++) {
                        boolean isScrambleNoSwap = dp[i][j][q] && dp[i + q][j + q][k - q];
                        boolean isScrambleWithSwap = dp[i][j + k - q][q] && dp[i + q][j][k - q];
                        if (isScrambleNoSwap || isScrambleWithSwap) {
                            dp[i][j][k] = true;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }

    /**
     * O(n!) brute force with pruning.
     */
    public boolean isScrambleBruteForce(String s1, String s2) {
        if (!isAnagram(s1, s2)) {
            return false;
        } else if (s1.equals(s2)) {
            return true;
        }

        // Choose split position
        for (int i = 1; i < s1.length(); i++) {
            // Choose swap or no swap
            if (isScrambleBruteForce(s1.substring(0, i), s2.substring(0, i))
                    && isScrambleBruteForce(s1.substring(i), s2.substring(i))) {
                return true;
            } else if (isScrambleBruteForce(s1.substring(0, i), s2.substring(s2.length() - i))
                    && isScrambleBruteForce(s1.substring(i), s2.substring(0, s2.length() - i))) {
                return true;
            }
        }
        return false;
    }

    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] letterBalance = new int[256];
        for (char c : s1.toCharArray()) {
            letterBalance[c]++;
        }
        for (char c : s2.toCharArray()) {
            letterBalance[c]--;
        }
        for (int i = 0; i < 256; i++) {
            if (letterBalance[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
