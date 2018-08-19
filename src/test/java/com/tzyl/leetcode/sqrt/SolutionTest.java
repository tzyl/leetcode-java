package com.tzyl.leetcode.sqrt;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        assertThat(solver.mySqrt(9), is(3));
    }

    @Test
    public void testSmallestCase() {
        assertThat(solver.mySqrt(0), is(0));
    }

    @Test
    public void testLargestCase() {
        assertThat(solver.mySqrt(Integer.MAX_VALUE), is(46340));
    }

    @Test
    public void testTruncate() {
        assertThat(solver.mySqrt(8), is(2));
    }
}
