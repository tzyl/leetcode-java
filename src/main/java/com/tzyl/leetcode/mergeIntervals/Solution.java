/**
 * 56. Merge Intervals
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 *
 * Example 2:
 *
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 */
package com.tzyl.leetcode.mergeIntervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return new ArrayList<>();
        }
        intervals.sort(Comparator.comparingInt(interval -> interval.start));
        List<Interval> mergedIntervals = new ArrayList<>();
        Interval merged = new Interval(intervals.get(0).start, intervals.get(0).end);
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= merged.end) {
                // Merge intervals
                if (intervals.get(i).end > merged.end) {
                    merged = new Interval(merged.start, intervals.get(i).end);
                }
            } else {
                mergedIntervals.add(merged);
                merged = new Interval(intervals.get(i).start, intervals.get(i).end);
            }
        }
        mergedIntervals.add(merged);
        return mergedIntervals;
    }
}

/**
 * Definition for an interval.
 */
class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval interval = (Interval) o;
        return start == interval.start &&
                end == interval.end;
    }
}
