package com.tzyl.leetcode.combinationSum2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        int[] candidates = new int[] { 2, 3, 5 };
        int target = 5;
        assertThat(solver.combinationSum2(candidates, target), containsInAnyOrder(
                Arrays.asList(5),
                Arrays.asList(2, 3)
        ));
    }

    @Test
    public void testRepeatCandidate() {
        int[] candidates = new int[] { 1, 1, 1 };
        int target = 2;
        assertThat(solver.combinationSum2(candidates, target), containsInAnyOrder(
                Arrays.asList(1, 1)
        ));
    }

    @Test
    public void testExample() {
        int[] candidates = new int[] { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        assertThat(solver.combinationSum2(candidates, target), containsInAnyOrder(
                Arrays.asList(2, 6),
                Arrays.asList(1, 7),
                Arrays.asList(1, 2, 5),
                Arrays.asList(1, 1, 6)
        ));
    }
}
