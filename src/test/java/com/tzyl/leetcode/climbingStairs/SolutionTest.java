package com.tzyl.leetcode.climbingStairs;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        assertThat(solver.climbStairs(3), is(3));
    }

    @Test
    public void testSmallestCase() {
        assertThat(solver.climbStairs(1), is(1));
    }
}
