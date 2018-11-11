package com.tzyl.leetcode.subsets;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        int[] nums = new int[]{1, 2, 3};
        assertThat(solver.subsets(nums), containsInAnyOrder(
                Arrays.asList(),
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3),
                Arrays.asList(1, 2),
                Arrays.asList(1, 3),
                Arrays.asList(2, 3),
                Arrays.asList(1, 2, 3)
        ));
    }

    @Test
    public void testSmallest() {
        int[] nums = new int[]{};
        assertThat(solver.subsets(nums), containsInAnyOrder(
                empty()
        ));
    }

    @Test
    public void testNoDuplicates() {
        int[] nums = new int[]{1, 1};
        assertThat(solver.subsets(nums), containsInAnyOrder(
                Arrays.asList(),
                Arrays.asList(1),
                Arrays.asList(1, 1)
        ));
    }
}
