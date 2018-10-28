package com.tzyl.leetcode.combinations;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        assertThat(solver.combine(4, 2), containsInAnyOrder(
                Arrays.asList(2, 4),
                Arrays.asList(3, 4),
                Arrays.asList(2, 3),
                Arrays.asList(1, 2),
                Arrays.asList(1, 3),
                Arrays.asList(1, 4)
        ));
    }

    @Test
    public void testSmallestN() {
        assertThat(solver.combine(1, 1), containsInAnyOrder(
                Arrays.asList(1)
        ));
    }

    @Test
    public void testSmallestK() {
        System.out.println(solver.combine(1000, 0));
        assertThat(solver.combine(1000, 0), containsInAnyOrder(
                empty()
        ));
    }
}
