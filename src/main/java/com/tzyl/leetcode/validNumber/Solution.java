/**
 * 65. Valid Number
 *
 * Validate if a given string is numeric.
 *
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 *
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 *
 * Update (2015-02-10):
 * The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button to reset your code definition.
 */
package com.tzyl.leetcode.validNumber;

public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        // Check for empty
        if (s.isEmpty()) {
            return false;
        }
        boolean foundExponential = false;
        boolean foundDecimal = false;
        boolean followsDigit = false;
        int maybeBeforeSign = -1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // Check for leading sign
            if ((i == maybeBeforeSign + 1) && (chars[i] == '+' || chars[i] == '-')) {
                continue;
            }
            // Check for digit
            if (Character.isDigit(chars[i])) {
                followsDigit = true;
                continue;
            }
            // Check for decimal
            if (chars[i] == '.') {
                if (foundDecimal || foundExponential) {
                    return false;
                }
                foundDecimal = true;
                continue;
            }
            // Check for exponential
            if (chars[i] == 'e') {
                if (foundExponential || !followsDigit) {
                    return false;
                }
                foundExponential = true;
                followsDigit = false;
                maybeBeforeSign = i;
                continue;
            }
            // Invalid character
            return false;
        }
        // Valid if we have a digit from the start and the exponential if present
        return followsDigit;
    }
}
