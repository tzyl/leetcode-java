package com.tzyl.leetcode.firstMissingPositive;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        assertThat(solver.firstMissingPositive(new int[] { 0, 1, -1, 2, -2, 4 }), is(equalTo(3)));
    }

    @Test
    public void testAlreadyInOrder() {
        assertThat(solver.firstMissingPositive(new int[] { 1, 2, 3 }), is(equalTo(4)));
    }

    @Test
    public void testDuplicateElementsInRange() {
        assertThat(solver.firstMissingPositive(new int[] { 1, 1 }), is(equalTo(2)));
    }
}
