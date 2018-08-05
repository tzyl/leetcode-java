package com.tzyl.leetcode.plusOne;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        assertThat(solver.plusOne(new int[]{1, 2, 9}), is(new int[]{1, 3, 0}));
    }

    @Test
    public void testSmallestCase() {
        assertThat(solver.plusOne(new int[]{0}), is(new int[]{1}));
    }

    @Test
    public void testCarryOver() {
        assertThat(solver.plusOne(new int[]{9}), is(new int[]{1, 0}));
    }
}
