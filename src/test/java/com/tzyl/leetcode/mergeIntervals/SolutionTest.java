package com.tzyl.leetcode.mergeIntervals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        List<Interval> intervals = Arrays.asList(
                new Interval(1, 3),
                new Interval(2, 6),
                new Interval(8, 10),
                new Interval(15, 18)
        );
        assertThat(solver.merge(intervals), containsInAnyOrder(
                equalTo(new Interval(1, 6)),
                equalTo(new Interval(8, 10)),
                equalTo(new Interval(15, 18))
        ));
    }

    @Test
    public void testEmpty() {
        List<Interval> intervals = Arrays.asList();
        assertThat(solver.merge(intervals), is(empty()));
    }

    @Test
    public void testUnsorted() {
        List<Interval> intervals = Arrays.asList(
                new Interval(2, 3),
                new Interval(1, 2)
        );
        assertThat(solver.merge(intervals), contains(
                equalTo(new Interval(1, 3))
        ));
    }
}
