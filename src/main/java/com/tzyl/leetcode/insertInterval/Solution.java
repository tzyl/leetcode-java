/**
 * 57. Insert Interval
 *
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 *
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 *
 *
 * Example 2:
 *
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
package com.tzyl.leetcode.insertInterval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        return merge(intervals);
    }

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