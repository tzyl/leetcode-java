/**
 * 77. Combinations
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Example:
 *
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 */
package com.tzyl.leetcode.combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int n;
    private int k;
    private List<List<Integer>> combinations;
    private List<Integer> current;

    /**
     * Backtracking solution to build all combinations of size k from first n positive integers.
     */
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        combinations = new ArrayList<>();
        current = new ArrayList<>();
        solve(1);
        return combinations;
    }

    private void solve(int start) {
        if (current.size() == k) {
            combinations.add(new ArrayList<>(current));
        } else if (start <= n) {
            for (int i = start; i <= n; i++) {
                current.add(i);
                solve(i + 1);
                current.remove(current.size() - 1);
            }
        }
    }
}
