/**
 * 89. Gray Code
 * <p>
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * <p>
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: 2
 * Output: [0,1,3,2]
 * Explanation:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * <p>
 * For a given n, a gray code sequence may not be uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence.
 * <p>
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: 0
 * Output: [0]
 * Explanation: We define the gray code sequence to begin with 0.
 *              A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
 *              Therefore, for n = 0 the gray code sequence is [0].
 */
package com.tzyl.leetcode.grayCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
        if (n == 0) {
            return Arrays.asList(0);
        } else if (n == 1) {
            return Arrays.asList(0, 1);
        }

        // Traverse hypercube by following path of hypercube with dimension n - 1 then following
        // the same path in reverse on the other side of the new dimension.
        List<Integer> sequence = new ArrayList<>(grayCode(n - 1));
        int length = (int) Math.pow(2, n - 1);
        for (int i = length - 1; i >= 0; i--) {
            sequence.add(length + sequence.get(i));
        }
        return sequence;
    }
}
