package com.tzyl.leetcode.grayCode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testThree() {
        int n = 3;
        List<Integer> expected = Arrays.asList(0, 1, 3, 2, 6, 7, 5 ,4);
        assertThat(solver.grayCode(n), is(expected));
    }

    @Test
    public void testTwo() {
        int n = 2;
        List<Integer> expected = Arrays.asList(0, 1, 3, 2);
        assertThat(solver.grayCode(n), is(expected));
    }

    @Test
    public void testOne() {
        int n = 1;
        List<Integer> expected = Arrays.asList(0, 1);
        assertThat(solver.grayCode(n), is(expected));
    }

    @Test
    public void testZero() {
        int n = 0;
        List<Integer> expected = Arrays.asList(0);
        assertThat(solver.grayCode(n), is(expected));
    }
}
