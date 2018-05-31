package com.tzyl.leetcode.trappingRainWater;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        int[] heights = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        assertThat(solver.trap(heights), is(equalTo(6)));
    }

    @Test
    public void testEmpty() {
        int[] heights = new int[] {};
        assertThat(solver.trap(heights), is(equalTo(0)));
    }
}
