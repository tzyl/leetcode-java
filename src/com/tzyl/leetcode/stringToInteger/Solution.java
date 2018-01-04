/**
 * 8. String to Integer (atoi)
 *
 * Implement atoi to convert a string to an integer.
 *
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 *
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 */
package com.tzyl.leetcode.stringToInteger;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int myAtoi(String str) {
        // Clean whitespace
        str = str.trim();
        // Find optional sign otherwise assume positive
        int sign = 1;
        int i = 0;
        if (str.isEmpty()) {
            return 0;
        } else if (str.charAt(i) == '+') {
            sign = 1;
            i++;
        } else if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        // Build integer from string.
        int x = 0;
        while (i < str.length()) {
            int digit = str.charAt(i) - '0';
            if (digit < 0 || digit > 9) break;
            // Check for overflow.
            if (x > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            x = 10 * x + digit;
            i++;
        }
        return x * sign;
    }
}