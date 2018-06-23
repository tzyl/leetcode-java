/**
 * 40. Combination Sum II
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
package com.tzyl.leetcode.combinationSum2;

import java.util.*;

public class Solution {
    // Uses backtracking to only store the current list in traversal.
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>(target + 1);
        Arrays.sort(candidates);
        search(candidates, target, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    /**
     * Searches for solution sets based on the current list using elements at
     * index start and onwards from candidates.
     *
     * @param candidates the full list of allowed integers
     * @param target the target to reach from current state
     * @param start the index to start from in candidates
     * @param current the current solution
     * @param solutionSet the current list of solutions
     */
    private void search(int[] candidates, int target, int start, List<Integer> current,
                        List<List<Integer>> solutionSet) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            solutionSet.add(new ArrayList<>(current));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    // If n duplicate candidates are needed use the first n of them to prevent duplicate solution sets.
                    // 1 1 1 Suppose need two 1s
                    // 1 1 x Use
                    // 1 x 1 Skip
                    // x 1 1 Skip
                    continue;
                }
                current.add(candidates[i]);
                search(candidates, target - candidates[i], i + 1, current, solutionSet);
                current.remove(current.size() - 1);
            }
        }
    }
}
