/**
 * 62. Unique Paths
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 *
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 *
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 *
 *
 * Example 2:
 *
 *
 * Input: m = 7, n = 3
 * Output: 28
 */
package com.tzyl.leetcode.uniquePaths;

public class Solution {
    public int uniquePaths(int m, int n) {
        return (int) binomialCoefficient(m + n - 2, m - 1);
    }

    private long binomialCoefficient(int n, int r) {
        if (r > n) {
            throw new IllegalArgumentException("r must be between 0 and n");
        } else if (r == 0) {
            return 1;
        } else if (r > n / 2) {
            return binomialCoefficient(n, n - r);
        }
        // Calculate binomial coefficient using nCr = n(n - 1)...(n - r + 1) / 1...r
        long x = 1;
        for (int i = 1; i <= r; i++) {
            // Safe as intermediate results are binomial coefficients which are integers
            x = x * (n + 1 - i) / i;
        }
        return x;
    }
}
