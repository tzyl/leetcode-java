/**
 * 22. Generate Parentheses
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
package com.tzyl.leetcode.generateParantheses;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        generateParenthesis("", n, n, result);
        return result;
    }

    private void generateParenthesis(String current, int open, int close, List<String> result) {
        if (open == 0 && close == 0) {
            result.add(current);
            return;
        }
        if (open > 0) generateParenthesis(current + "(", open - 1, close, result);
        if (close > open) generateParenthesis(current + ")", open, close - 1, result);
    }
}
