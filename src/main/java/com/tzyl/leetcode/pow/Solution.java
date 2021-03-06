/**
 * 50. Pow(x, n)
 *
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 *
 * Example 1:
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 *
 * Example 2:
 *
 * Input: 2.10000, 3
 * Output: 9.26100
 *
 * Example 3:
 *
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
 *
 * Note:
 *
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
 *
 */
package com.tzyl.leetcode.pow;

public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            // Prevent int overflow
            if (n == Integer.MIN_VALUE) {
                return 1 / x * myPow(x, n + 1);
            } else {
                return myPow(1 / x, -n);
            }
        } else {
            if (n % 2 == 1) {
                return x * myPow(x, n - 1);
            } else {
                return myPow(x * x, n / 2);
            }
        }
    }
}
