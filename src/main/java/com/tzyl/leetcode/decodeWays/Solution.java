/**
 * 91. Decode Ways
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 *
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 *
 *
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 *
 *
 * Example 2:
 *
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
package com.tzyl.leetcode.decodeWays;

public class Solution {
    public int numDecodings(String s) {
        // Recursive relation
        // Let numDecodings(s, i) = numDecodings(s[i:])
        //
        // Then for i >= s.length:
        //   numDecodings(s, i) = 1 (the empty string can only be decoded one way)
        //
        // For 0 <= i < s.length:
        // If s[i] == '0':
        //   numDecodings(s, i) = 0
        // Else:
        //   numDecodings(s, i) =
        //     numDecodings(s, i + 1) // decode s[i] as single character
        //     + numDecodings(s, i + 2) // decode s[i:i+2] as double character if in range 10..26
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                int partialNumDecodings = dp[i + 1];
                if (i + 1 < s.length() && isDoubleDigitLetter(s.substring(i, i + 2))) {
                    partialNumDecodings += dp[i + 2];
                }
                dp[i] = partialNumDecodings;
            }

        }
        return dp[0];
    }

    private static boolean isDoubleDigitLetter(String s) {
        int parsed = Integer.parseInt(s);
        return 10 <= parsed && parsed <= 26;
    }
}
