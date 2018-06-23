/**
 * 23. Merge k Sorted Lists
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
package com.tzyl.leetcode.mergeKSortedLists;

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //  Min priority queue with current list nodes.
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode oneBeforeStart = new ListNode(Integer.MIN_VALUE);
        ListNode current = oneBeforeStart;
        if (lists != null && lists.length > 0) {
            PriorityQueue<ListNode> minPriorityQueue = new PriorityQueue<>(lists.length, new ListNodeComparator());
            for (ListNode list : lists) {
                if (list != null) {
                    minPriorityQueue.add(list);
                }
            }
            while (!minPriorityQueue.isEmpty()) {
                // Get the next smallest list node.
                ListNode nextNode = minPriorityQueue.poll();
                current.next = nextNode;
                if (nextNode.next != null) {
                    minPriorityQueue.add(nextNode.next);
                }
                current = current.next;
            }
        }
        return oneBeforeStart.next;
    }
}

class ListNodeComparator implements Comparator<ListNode> {
    @Override
    public int compare(ListNode l1, ListNode l2) {
        // Assumes ListNodes are not null.
        return l1.val - l2.val;
    }
}

class SolutionBruteForce {
    // Brute force reduce mergeTwoLists.
    public ListNode mergeKLists(ListNode[] lists) {
        return Arrays.stream(lists).reduce(null, (ListNode l1, ListNode l2) -> mergeTwoLists(l1, l2));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode oneBeforeStart = new ListNode(Integer.MIN_VALUE);
        ListNode current = oneBeforeStart;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        current.next = (l1 != null) ? l1 : l2;
        return oneBeforeStart.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
