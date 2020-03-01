package com.tzyl.leetcode.decodeWays;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    // * Example 1:
    //  *
    //  *
    //  * Input: "12"
    //  * Output: 2
    //  * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
    //  *
    //  *
    //  * Example 2:
    //  *
    //  *
    //  * Input: "226"
    //  * Output: 3
    //  * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
    //  */

    @Test
    public void testExampleOne() {
        String input = "12";
        int expected = 2;
        assertThat(solver.numDecodings(input), is(expected));
    }

    @Test
    public void testExampleTwo() {
        String input = "226";
        int expected = 3;
        assertThat(solver.numDecodings(input), is(expected));
    }

    @Test
    public void testValidZero() {
        String input = "1020";
        int expected = 1;
        assertThat(solver.numDecodings(input), is(expected));
    }

    @Test
    public void testOnlyZero() {
        String input = "0";
        int expected = 0;
        assertThat(solver.numDecodings(input), is(expected));
    }

    @Test
    public void testInvalid() {
        String input = "1230";
        int expected = 0;
        assertThat(solver.numDecodings(input), is(expected));
    }

    @Test
    public void testEmpty() {
        String input = "";
        int expected = 1;
        assertThat(solver.numDecodings(input), is(expected));
    }
}
