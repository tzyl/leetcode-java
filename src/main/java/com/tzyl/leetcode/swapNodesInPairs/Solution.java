/**
 * 24. Swap Nodes in Pairs
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
package com.tzyl.leetcode.swapNodesInPairs;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode sentinel = new ListNode(Integer.MIN_VALUE);
        sentinel.next = head;
        ListNode prev = sentinel;
        // Swap pair if both are not null.
        while (prev.next != null && prev.next.next != null) {
            ListNode current = prev.next;
            ListNode next = current.next;
            current.next = next.next;
            next.next = current;
            prev.next = next;
            // Move to next pair.
            prev = prev.next.next;
        }
        return sentinel.next;
    }

    public ListNode swapPairsRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairsRecursive(head.next.next);
        newHead.next = head;
        return newHead;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}