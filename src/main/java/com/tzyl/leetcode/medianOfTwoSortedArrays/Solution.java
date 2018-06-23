/**
 * 4. Median of Two Sorted Arrays
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 */
package com.tzyl.leetcode.medianOfTwoSortedArrays;

public class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            return findMedianSortedArrays(B, A);
        }

        // A[:i] and B[:j] on the left. We try to make equal number of elements
        // on the left as right while also having all elements on the left less than on
        // the right so we can find the median.
        int i = 0;
        int j = 0;
        int iMin = 0;
        int iMax = m;
        int midPoint = (n + m + 1) / 2;
        while (iMin <= iMax) {
            i = (iMin + iMax) / 2;
            j = midPoint - i;
            // Now we have equal elements on left and right.
            // Check if A[i - 1] < B[j] and B[j - 1] < A[i] so max(left) < min(right).
            // Check if one side contains all of A or B to fix edge cases.
            if (i < m && B[j - 1] > A[i]) {
                // i is too small so we increase lower bound iMin.
                iMin = i + 1;
            } else if (i > 0 && A[i - 1] > B[j]) {
                // i is too large so we decrease upper bound iMax.
                iMax = i - 1;
            } else {
                // We have found the correct index i.
                break;
            }
        }
        int maxOfLeft;
        if (i == 0) maxOfLeft = B[j - 1];
        else if (j == 0) maxOfLeft = A[i - 1];
        else maxOfLeft = A[i - 1] > B[j - 1] ? A[i - 1] : B[j - 1];

        // Check if odd number of elements then the median is just max of the left.
        if ((m + n) % 2 == 1) return maxOfLeft;

        int minOfRight;
        if (i == m) minOfRight = B[j];
        else if (j == n) minOfRight = A[i];
        else minOfRight = A[i] < B[j] ? A[i] : B[j];

        return (maxOfLeft + minOfRight) / 2.0;
    }
}
