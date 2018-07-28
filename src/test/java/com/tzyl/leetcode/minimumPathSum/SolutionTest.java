package com.tzyl.leetcode.minimumPathSum;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class SolutionTest {
	private final Solution solver = new Solution();

	@Test
	public void testBasicCase() {
		int[][] grid = new int[][]{
				new int[]{1, 3, 1},
				new int[]{1, 5, 1},
				new int[]{4, 2, 1},
		};
		assertThat(solver.minPathSum(grid), is(equalTo(7)));
	}
}
