/**
 * 76. Minimum Window Substring
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example:
 *
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 *
 *
 * Note:
 *
 *
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 *
 */
package com.tzyl.leetcode.minimumWindowSubstring;

import java.util.*;

public class Solution {
    private String s;
    private String t;
    private String window;
    private boolean windowExists;
    private Deque<Integer> marked;
    private Map<Character, Integer> counts;
    private Map<Character, Integer> targetCounts;

    public String minWindow(String s, String t) {
        this.s = s;
        this.t = t;
        this.windowExists = false;
        this.marked = new ArrayDeque<>();
        this.counts = new HashMap<>();
        this.targetCounts = getTargetCounts(t);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (targetCounts.containsKey(c)) {
                mark(i);
                removeRedundantMarks();
                checkWindow();
            }
        }

        if (!windowExists) {
            return "";
        }
        return window;
    }

    private void mark(int i) {
        char c = s.charAt(i);
        int count = counts.getOrDefault(c, 0);
        marked.addLast(i);
        counts.put(c, count + 1);
    }

    private void removeRedundantMarks() {
        char c = s.charAt(marked.getFirst());
        int count = counts.getOrDefault(c, 0);
        while (count > targetCounts.get(c)) {
            counts.put(c, count - 1);
            marked.removeFirst();
            c = s.charAt(marked.getFirst());
            count = counts.getOrDefault(c, 0);
        }
    }

    private void checkWindow() {
        if (isValidWindow()) {
            windowExists = true;
            if (window == null || marked.getLast() + 1 - marked.getFirst() < window.length()) {
                window = s.substring(marked.getFirst(), marked.getLast() + 1);
            }
        }
    }

    private boolean isValidWindow() {
        for (Map.Entry<Character, Integer> entry : targetCounts.entrySet()) {
            if (counts.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> getTargetCounts(String t) {
        Map<Character, Integer> targetCounts = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetCounts.put(c, targetCounts.getOrDefault(c, 0) + 1);
        }
        return targetCounts;
    }
}
