package com.tzyl.leetcode.permutations;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        int[] nums = new int[] { 1, 2, 3 };
        assertThat(solver.permute(nums), containsInAnyOrder(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 3, 2),
                Arrays.asList(2, 1, 3),
                Arrays.asList(2, 3, 1),
                Arrays.asList(3, 1, 2),
                Arrays.asList(3, 2, 1)
        ));
    }
}
