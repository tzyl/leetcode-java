/**
 * 39. Combination Sum
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *    [7],
 *    [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *    [2,2,2,2],
 *    [2,3,3],
 *    [3,5]
 * ]
 */
package com.tzyl.leetcode.combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    // Uses backtracking to only store the current list in traversal.
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                current.add(candidates[i]);
                search(candidates, target - candidates[i], i, current, solutionSet);
                current.remove(current.size() - 1);
            }
        }
    }

    // Stores all partial combination sums.
    public List<List<Integer>> combinationSumAllPartial(int[] candidates, int target) {
        // partialCombinations[i] holds all combinations summing to i.
        List<List<List<Integer>>> partialCombinations = new ArrayList<>(target + 1);
        for (int i = 0; i <= target; i++) {
            partialCombinations.add(new ArrayList<>());
        }
        // Add empty list for zero sum.
        partialCombinations.get(0).add(new ArrayList<>());

        // Create all combinations by adding each candidate at a time.
        for (int x : candidates) {
            for (int i = target; i > 0; i--) {
                for (int m = 1; i - m * x >= 0; m++) {
                    for (List<Integer> combination : partialCombinations.get(i - m * x)) {
                        List<Integer> newCombination = new ArrayList<>(combination);
                        newCombination.addAll(Collections.nCopies(m, x));
                        partialCombinations.get(i).add(newCombination);
                    }
                }
            }
        }

        return partialCombinations.get(target);
    }
}
