package com.tzyl.leetcode.searchInsertPosition;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        assertThat(solver.searchInsert(new int[] { 1, 2, 3, 4 }, 2), is(equalTo(1)));
    }

    @Test
    public void testEmpty() {
        assertThat(solver.searchInsert(new int[] {}, 1), is(equalTo(0)));
    }

    @Test
    public void testBeginning() {
        assertThat(solver.searchInsert(new int[] { 1, 2, 3, 4 }, 1), is(equalTo(0)));
    }

    @Test
    public void testEnd() {
        assertThat(solver.searchInsert(new int[] { 1, 2, 3, 4 }, 4), is(equalTo(3)));
    }

    @Test
    public void testNoTargetAtEnd() {
        assertThat(solver.searchInsert(new int[] { 1, 2, 3, 4 }, 5), is(equalTo(4)));
    }

    @Test
    public void testNoTargetInMiddle() {
        assertThat(solver.searchInsert(new int[] { 1, 3, 5, 7 }, 2), is(equalTo(1)));
    }

    @Test
    public void testNoTargetAtBeginning() {
        assertThat(solver.searchInsert(new int[] { 1, 2, 3, 4 }, 0), is(equalTo(0)));
    }
}
