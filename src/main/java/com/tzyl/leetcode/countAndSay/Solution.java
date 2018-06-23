/**
 * 38. Count and Say
 *
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 * Example 1:
 *
 * Input: 1
 * Output: "1"
 * Example 2:
 *
 * Input: 4
 * Output: "1211"
 */
package com.tzyl.leetcode.countAndSay;

public class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 2; i <= n; i++) {
            result = nextIteration(result);
        }
        return result;
    }

    private String nextIteration(String current) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 0; i < current.length(); i++) {
            if (i == current.length() - 1 || current.charAt(i) != current.charAt(i + 1)) {
                result.append(Character.forDigit(count, 10)).append(current.charAt(i));
                count = 0;
            }
            count++;
        }
        return result.toString();
    }
}
