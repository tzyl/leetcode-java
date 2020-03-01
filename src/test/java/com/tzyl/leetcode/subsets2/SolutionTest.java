package com.tzyl.leetcode.subsets2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testExample() {
        int[] input = new int[]{1, 2, 2};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(1, 2),
                Arrays.asList(2, 2),
                Arrays.asList(1, 2, 2));
        assertThat(solver.subsetsWithDup(input), containsInAnyOrder(expected.toArray()));
    }

    @Test
    public void testDuplicates() {
        int[] input = new int[]{1, 1, 1};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(1),
                Arrays.asList(1, 1),
                Arrays.asList(1, 1, 1));
        assertThat(solver.subsetsWithDup(input), containsInAnyOrder(expected.toArray()));
    }

    @Test
    public void testEmpty() {
        int[] input = new int[]{};
        List<Integer> expected = Arrays.asList(0, 1, 3, 2);
        assertThat(solver.subsetsWithDup(input), contains(empty()));
    }
}
