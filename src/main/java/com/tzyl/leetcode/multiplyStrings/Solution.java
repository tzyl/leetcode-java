/**
 * 43. Multiply Strings
 *
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *
 * Example 1:
 *
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 *
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * Note:
 *
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
package com.tzyl.leetcode.multiplyStrings;

public class Solution {
    public String multiply(String num1, String num2) {
        // Calculate product of each digit
        int[] digits = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                int digit1 = num1.charAt(num1.length() - 1 - i) - '0';
                int digit2 = num2.charAt(num2.length() -1 - j) - '0';
                digits[i + j] += digit1 * digit2;
            }
        }

        // Carry over digits
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] >= 10) {
                digits[i + 1] += digits[i] / 10;
                digits[i] %= 10;
            }
        }

        // Add digits in reverse ignoring leading zeros
        StringBuilder sb = new StringBuilder(digits.length);
        int i = digits.length - 1;
        while (i >= 0 && digits[i] == 0) {
            i--;
        }
        while (i >= 0) {
            sb.append(Character.forDigit(digits[i], 10));
            i--;
        }
        return (sb.length() != 0) ? sb.toString() : "0";
    }
}
