/**
 * 7. Reverse Integer
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 
 * Example 1:
 * 
 * Input: 123
 * Output:  321
 * Example 2:
 * 
 * Input: -123
 * Output: -321
 * Example 3:
 * 
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
package com.tzyl.leetcode.reverseInteger;

public class Solution {
    public int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
            int newReversed = reversed * 10 + x % 10;
            if (reversed != (newReversed - (x % 10)) / 10) {
                //  We overflowed int.
                return 0;
            }
            reversed = newReversed;
            x /= 10;
        }
        return reversed;
    }
}
