package com.tzyl.leetcode.multiplyStrings;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        assertThat(solver.multiply("12", "34"), is(equalTo("408")));
    }

    @Test
    public void testZeroProduct() {
        assertThat(solver.multiply("0", "1"), is(equalTo("0")));
    }
}
