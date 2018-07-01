package com.tzyl.leetcode.jumpGame;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testPossible() {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        assertThat(solver.canJump(nums), is(true));
    }

    @Test
    public void testNotPossible() {
        int[] nums = new int[]{3, 2, 1, 0, 4};
        assertThat(solver.canJump(nums), is(false));
    }

    @Test
    public void testNoJumps() {
        int[] nums = new int[]{0};
        assertThat(solver.canJump(nums), is(true));
    }
}
