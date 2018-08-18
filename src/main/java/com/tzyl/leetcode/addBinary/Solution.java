/**
 * 67. Add Binary
 *
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 *
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Example 2:
 *
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
package com.tzyl.leetcode.addBinary;

public class Solution {
    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        int x = Math.max(m, n);
        int[] sum = new int[x + 1];
        for (int i = 0; i < x; i++) {
            if (m - 1 - i >= 0 && a.charAt(m - 1 - i) == '1') {
                sum[x - i]++;
            }
            if (n - 1 - i >= 0 && b.charAt(n - 1 - i) == '1') {
                sum[x - i]++;
            }
            // Check carry over
            if (sum[x - i] >= 2) {
                sum[x - i] -= 2;
                sum[x - i - 1]++;
            }
        }
        return createDigitString(sum);
    }

    private String createDigitString(int[] digits) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while (start < digits.length - 1 && digits[start] == 0) {
            start++;
        }
        for (int i = start; i < digits.length; i++) {
            sb.append(Character.forDigit(digits[i], 10));
        }
        return sb.toString();
    }
}
