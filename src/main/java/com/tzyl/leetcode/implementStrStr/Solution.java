/**
 * 28. Implement strStr()
 *
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 */
package com.tzyl.leetcode.implementStrStr;

public class Solution {
    // Knuth-Morris-Pratt algorithm worst case O(n).
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (m == 0) return 0;
        if (n < m) return -1;
        int[] pi = computePrefixFunction(needle);
        int q = 0;
        for (int i = 0; i < n; i++) {
            while (q > 0 && needle.charAt(q) != haystack.charAt(i)) {
                q = pi[q];
            }
            if (needle.charAt(q) == haystack.charAt(i)) {
                q++;
            }
            if (q == m) {
                return i - q + 1;
            }
        }
        return -1;
    }

    private int[] computePrefixFunction(String needle) {
        int m = needle.length();
        int[] pi = new int[m + 1];
        pi[1] = 0;
        int k = 0;
        for (int q = 1; q < m; q++) {
            while (k > 0 && needle.charAt(k) != needle.charAt(q)) {
                k = pi[k];
            }
            if (needle.charAt(k) == needle.charAt(q)) {
                k++;
            }
            pi[q + 1] = k;
        }
        return pi;
    }

    // Brute force algorithm worst case O(mn).
    public int strStr_bruteForce(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (m == 0) return 0;
        if (n < m) return -1;
        for (int i = 0; i < m - n + 1; i++) {
            for (int j = 0; j < n; j++){
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                } else if (j == n - 1) {
                    return i;
                }
            }
        }
        return -1;
    }
}
