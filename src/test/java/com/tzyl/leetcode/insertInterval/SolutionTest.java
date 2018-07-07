package com.tzyl.leetcode.insertInterval;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        List<Interval> intervals = new ArrayList<>(Arrays.asList(
                new Interval(1, 3),
                new Interval(6, 9)
        ));
        Interval newInterval = new Interval(2, 5);
        assertThat(solver.insert(intervals, newInterval), containsInAnyOrder(
                equalTo(new Interval(1, 5)),
                equalTo(new Interval(6, 9))
        ));
    }
}
