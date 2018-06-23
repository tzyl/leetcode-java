package com.tzyl.leetcode.longestValidParentheses;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SolutionTest {
    private final Solution solver = new Solution();

    @Test
    public void testBasicCase() {
        assertThat(solver.longestValidParentheses("()"), is(equalTo(2)));
        assertThat(solver.longestValidParentheses(""), is(equalTo(0)));
        assertThat(solver.longestValidParentheses(")("), is(equalTo(0)));
        assertThat(solver.longestValidParentheses("(()"), is(equalTo(2)));
    }

    @Test
    public void testEnclosingLongest() {
        assertThat(solver.longestValidParentheses("(())"), is(equalTo(4)));
        assertThat(solver.longestValidParentheses("((()))"), is(equalTo(6)));
        assertThat(solver.longestValidParentheses("(((())))"), is(equalTo(8)));
    }

    @Test
    public void testAdjacentLongest() {
        assertThat(solver.longestValidParentheses("()()"), is(equalTo(4)));
        assertThat(solver.longestValidParentheses("()()()"), is(equalTo(6)));
        assertThat(solver.longestValidParentheses("()()()()"), is(equalTo(8)));
    }

    @Test
    public void testMixedLongest() {
        assertThat(solver.longestValidParentheses("(()()()())(()()()())"), is(equalTo(20)));
        assertThat(solver.longestValidParentheses("(()()()())(()()()())))))))))))((((("), is(equalTo(20)));
    }

    @Test
    public void testSpeed() {
        assertThat(solver.longestValidParentheses("()()()(()))()()())))((()()()(()()))(()()()((()()))())(((())()())(()(()(()(())(((()())()))(()))()))))()())(()))))()()(())()()((())()()))))((()))))(()()((()(()(()())((())()()()()))()()()(())()()())((((()(())())))(((()(((()((((())())(()()()()(((((()))()(()(())))(((()()()()(()(((())(()(()()(()(()(())()))))))()))()())((()((((()(())(()()()(((((()())()))))())))((((()()()(()(())(((())(((()()((()((()(((()(()))(((())(((()((((()(())(((()((()(()())))))(()(()()(())))))()(()()((()))()))())())((())))()(())((((()((()))))()())()))((()(()())()())()()((()))())(()(()(())((((((()()((((())))())(((()()())))()(((()(()()((((())))))()()((((()(()()())(()(())()()()((()(()((((())))((((((())(()())()))))(()(()))()))))))(()()((()()()())(())))(((()))(()()()(()))((())()()()())()()(((())(()(())()()(()())((()()(((((())(()((((()(()()()(()))(()((((())()())()())())))())(((()(()((())()()((((()()()()))))))())())()(((((()())()(()()()()()(((())((((((()))(())()(()())(()(()())(()(())))())))(()()(()((((()()(())(()))()))(()))(()())())()))))))()()(())))))()))()(()())))((())(()()))()((()))()(())()()((((())()))((()(()))()(((()())()(()()((()())((((())()))))()(())())())())(((()(()())))((()))))()())))))(()((())))()())((()))()()))(())())()))()()((()(((())()()()((()()(()(())(()))())())(((()())(()())(()((()()()())()(()(((((((()()(((()(((((((())(()))))())()))))))))()(()(()((((())(()()(((()))()(())(((((((((()(()())())()(((()((()(((()(()()(()))(())))))))((("), is(equalTo(590)));
    }
}
