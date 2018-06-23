package com.tzyl.leetcode.searchInRotatedSortedArray;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        assertThat(solver.search(new int[] { 3, 4, 1, 2 }, 1), is(equalTo(2)));
    }

    @Test
    public void testNoPivot() {
        assertThat(solver.search(new int[] { 1, 2, 3, 4 }, 1), is(equalTo(0)));
    }

    @Test
    public void testNoTarget() {
        assertThat(solver.search(new int[] { 1, 2, 3, 4 }, 5), is(equalTo(-1)));
    }

    @Test
    public void testEmptyInput() {
        assertThat(solver.search(new int[] {}, 1), is(equalTo(-1)));
    }

    @Test
    public void testLengthOne() {
        assertThat(solver.search(new int[] { 1 }, 1), is(equalTo(0)));
    }

    @Test
    public void testLengthTwo() {
        assertThat(solver.search(new int[] {2, 1}, 1), is(equalTo(1)));
    }
}
