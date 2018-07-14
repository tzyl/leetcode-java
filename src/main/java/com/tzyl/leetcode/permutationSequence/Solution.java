/**
 * 60. Permutation Sequence
 *
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 *
 *
 * Given n and k, return the kth permutation sequence.
 *
 * Note:
 *
 *
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 *
 *
 * Example 1:
 *
 *
 * Input: n = 3, k = 3
 * Output: "213"
 *
 *
 * Example 2:
 *
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 *
 */
package com.tzyl.leetcode.permutationSequence;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * O(n^2) by calculating the permutation from left to right and using an
     * array to track currently unused numbers.
     */
    public String getPermutation(int n, int k) {
        // Track unused numbers
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        // Pre-calculate factorial
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = i * factorial[i- 1];
        }
        // Zero-index k
        k--;
        // Calculate digit left to right
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int idx = k / factorial[n - 1 - i];
            sb.append(nums.get(idx));
            nums.remove(idx);
            k -= idx * factorial[n - 1 - i];
        }
        return sb.toString();
    }
}
