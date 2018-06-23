package com.tzyl.leetcode.pow;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        assertThat(solver.myPow(2.0, 10), is(equalTo(1024.0)));
    }

    @Test
    public void testNegativeExponent() {
        assertThat(solver.myPow(2.0, -10), is(equalTo(1/1024.0)));
    }

    @Test
    public void testMaxExponent() {
        assertThat(solver.myPow(1.0, 1 << 31 - 1), is(equalTo(1.0)));
        assertThat(solver.myPow(1.0, -1 << 31), is(equalTo(1.0)));
    }
}
