/**
 * Divide two integers without using multiplication, division and mod operator.
 *
 * If it is overflow, return MAX_INT.
 */
package com.tzyl.leetcode.divideTwoIntegers;

public class Solution {
    public int divide(int dividend, int divisor) {
        // Deal with integer overflow which can happen because of signed ints or division by zero
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;
        // Deal with negative signs
        boolean sign = !((dividend < 0) ^ (divisor < 0));
        // Use long to deal with absolute value of min integer
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        // Solve using bit shift
        int quotient = 0;
        while (absDivisor <= absDividend) {
            long total = absDivisor;
            long multiple = 1;
            while ((total << 1) <= absDividend) {
                total <<= 1;
                multiple <<= 1;
            }
            quotient += multiple;
            absDividend -= total;
        }
        return sign ? quotient : -quotient;
    }
}
