/**
 * 19. Remove Nth Node From End of List
 *
 * Given a linked list, remove the nth node from the end of list and return its head.
 * 
 * For example,
 * 
 *    Given linked list: 1->2->3->4->5, and n = 2.
 * 
 *    After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */
package com.tzyl.leetcode.removeNthNodeFromEndOfList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = head;
        ListNode current = head;
        ListNode ahead = head;
        for (int i = 0; i < n; i++) ahead = ahead.next;
        while (ahead != null) {
            ahead = ahead.next;
            prev = current;
            current = current.next;
        }
        // Delete current node which is now nth from end.
        // If prev is the same as current then we need to delete the first
        // element so just return element after head.
        if (prev == current) return head.next;
        prev.next = current.next;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
