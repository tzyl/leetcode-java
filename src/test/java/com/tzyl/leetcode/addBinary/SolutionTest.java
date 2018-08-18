package com.tzyl.leetcode.addBinary;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        assertThat(solver.addBinary("11", "1"), is("100"));
    }

    @Test
    public void testSmallestCase() {
        assertThat(solver.addBinary("0", "0"), is("0"));
    }
}
