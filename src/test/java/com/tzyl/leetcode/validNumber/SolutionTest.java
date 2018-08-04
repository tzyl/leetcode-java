package com.tzyl.leetcode.validNumber;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        assertThat(solver.isNumber("0"), is(true));
    }

    @Test
    public void testEmpty() {
        assertThat(solver.isNumber(""), is(false));
    }

    @Test
    public void testPositive() {
        assertThat(solver.isNumber("+1"), is(true));
        assertThat(solver.isNumber("+0"), is(true));
    }

    @Test
    public void testNegative() {
        assertThat(solver.isNumber("-1"), is(true));
        assertThat(solver.isNumber("-0"), is(true));
    }

    @Test
    public void testWhitespace() {
        assertThat(solver.isNumber(" 1 "), is(true));
        assertThat(solver.isNumber("1 1"), is(false));
        assertThat(solver.isNumber("+ 1"), is(false));
        assertThat(solver.isNumber("- 1"), is(false));
        assertThat(solver.isNumber("1 e10"), is(false));
        assertThat(solver.isNumber("1e 10"), is(false));
    }

    @Test
    public void testDecimal() {
        assertThat(solver.isNumber("0.1"), is(true));
        assertThat(solver.isNumber(".1"), is(true));
        assertThat(solver.isNumber(".10"), is(true));
        assertThat(solver.isNumber("-.10"), is(true));
        assertThat(solver.isNumber("+.10"), is(true));
        assertThat(solver.isNumber("1."), is(true));
        assertThat(solver.isNumber("."), is(false));
    }

    @Test
    public void testLetters() {
        assertThat(solver.isNumber("abc"), is(false));
        assertThat(solver.isNumber("a1"), is(false));
        assertThat(solver.isNumber("1a"), is(false));
    }

    @Test
    public void testExponentialNotation() {
        assertThat(solver.isNumber("1e10"), is(true));
        assertThat(solver.isNumber("1e+10"), is(true));
        assertThat(solver.isNumber("1e-10"), is(true));
        assertThat(solver.isNumber(".1e10"), is(true));
        assertThat(solver.isNumber("+.1e+10"), is(true));
        assertThat(solver.isNumber("-.1e-10"), is(true));
        assertThat(solver.isNumber("1e"), is(false));
    }

    @Test
    public void testDecimalBeforeExponential() {
        assertThat(solver.isNumber("1.1e+1"), is(true));
        assertThat(solver.isNumber("1e1.1"), is(false));
    }
}
