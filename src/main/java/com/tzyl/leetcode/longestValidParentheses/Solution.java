/**
 * 32. Longest Valid Parentheses
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 *
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 *
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */
package com.tzyl.leetcode.longestValidParentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    // O(n) DP solution
    public int longestValidParentheses(String s) {
        int n = s.length();
        int longest = 0;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            // Valid parentheses must end with closing parenthesis.
            // If previous character is a closing parenthesis then the longest valid substring ending
            // at s[i] must contain the longest valid substring ending at s[i - 1] and the longest valid substring
            // ending two characters before the start of that one.
            // If previous character is an opening parenthesis then the longest valid substring ending
            // at s[i] is 2 + the longest valid substring ending at s[i - 2].
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == ')' && dp[i - 1] != i && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2;
                    if (i - dp[i - 1] - 2 >= 0) {
                        dp[i] += dp[i - dp[i - 1] - 2];
                    }
                } else if (s.charAt(i - 1) == '(') {
                    dp[i] = 2;
                    if (i - 2 >= 0) {
                        dp[i] += dp[i - 2];
                    }
                }
            }
            if (dp[i] > longest) {
                longest = dp[i];
            }
        }
        return longest;
    }

    // O(n) stack solution
    public int longestValidParenthesesStack(String s) {
        int n = s.length();
        int longest = 0;
        Deque<Integer> stack = new ArrayDeque<>(n);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    // Check length of this valid substring.
                    stack.pop();
                    int start = stack.isEmpty() ? 0 : stack.peek() + 1;
                    if (i - start + 1 > longest) {
                        longest = i - start + 1;
                    }
                } else {
                    // Push this '(' index as a boundary that valid substrings afterwards cannot cross.
                    stack.push(i);
                }
            }
        }
        return longest;
    }
}
