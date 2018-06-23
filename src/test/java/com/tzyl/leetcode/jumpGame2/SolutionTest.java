package com.tzyl.leetcode.jumpGame2;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        int[] nums = new int[] { 2, 3, 1, 1, 4 };
        assertThat(solver.jump(nums), is(2));
    }

    @Test
    public void testJumpZero() {
        int[] nums = new int[] { 2, 0, 2, 0, 0 };
        assertThat(solver.jump(nums), is(2));
    }

    @Test
    public void testMultipleRoutesSameMin() {
        int[] nums = new int[] { 2, 2, 2, 1, 0 };
        assertThat(solver.jump(nums), is(2));
    }
}
