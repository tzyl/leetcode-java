package com.tzyl.leetcode.searchForARange;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        assertThat(
                solver.searchRange(new int[] { 1, 2, 2, 3 }, 2),
                is(equalTo(new int[] { 1, 2 }))
        );
    }

    @Test
    public void testEmpty() {
        assertThat(
                solver.searchRange(new int[] {}, 1),
                is(equalTo(new int[] { -1, -1 }))
        );
    }

    @Test
    public void testNoTarget() {
        assertThat(
                solver.searchRange(new int[] { 1, 2, 3, 4 }, 5),
                is(equalTo(new int[] { -1, -1 }))
        );
    }

    @Test
    public void testOnlyOneTarget() {
        assertThat(
                solver.searchRange(new int[] { 1, 2, 3, 4 }, 1),
                is(equalTo(new int[] { 0, 0 }))
        );
    }

    @Test
    public void testManyTargets() {
        assertThat(
                solver.searchRange(new int[] { 1, 1, 1, 1 }, 1),
                is(equalTo(new int[] { 0, 3 }))
        );
    }
}
