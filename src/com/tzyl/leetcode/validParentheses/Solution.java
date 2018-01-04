/**
 * 20. Valid Parentheses
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
package com.tzyl.leetcode.validParentheses;

import java.util.*;

public class Solution {
    private static HashMap<Character, Character> closeToOpen = new HashMap<>();

    static {
        closeToOpen.put(')', '(');
        closeToOpen.put('}', '{');
        closeToOpen.put(']', '[');
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (closeToOpen.containsValue(c)) {
                stack.push(c);
            } else if (closeToOpen.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != closeToOpen.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
