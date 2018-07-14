package com.tzyl.leetcode.permutationSequence;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        assertThat(solver.getPermutation(4, 9), is("2314"));
    }

    @Test
    public void testSmallestCase() {
        assertThat(solver.getPermutation(1, 1), is("1"));
    }

    @Test
    public void testLargestCase() {
        assertThat(solver.getPermutation(9, 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1), is("987654321"));
    }
}
