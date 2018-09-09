package com.tzyl.leetcode.editDistance;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        assertThat(solver.minDistance("horse", "ros"), is(3));
    }

    @Test
    public void testSmallestCase() {
        assertThat(solver.minDistance("", ""), is(0));
    }

    @Test
    public void testInsert() {
        assertThat(solver.minDistance("abc", "abcd"), is(1));
    }

    @Test
    public void testDelete() {
        assertThat(solver.minDistance("abcd", "abc"), is(1));
    }

    @Test
    public void testReplace() {
        assertThat(solver.minDistance("abc", "abd"), is(1));
    }
}
