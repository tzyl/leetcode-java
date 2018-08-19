/**
 * 69. Sqrt(x)
 *
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * Example 1:
 *
 *
 * Input: 4
 * Output: 2
 *
 *
 * Example 2:
 *
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 *
 */
package com.tzyl.leetcode.sqrt;

public class Solution {
    public int mySqrt(int x) {
        // Newton's method
        long root = x;
        while (root * root > x) {
            root = (root + x / root) / 2;
        }
        return (int) root;
    }
}
