package com.smpaaark.leetcode.divideconquer;

public class Q148 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        fast = slow;

        ListNode left = sortList(head);
        ListNode right = sortList(fast);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode fakeHead = new ListNode();
        ListNode prev = fakeHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                prev.next = left;
                left = left.next;
            } else {
                prev.next = right;
                right = right.next;
            }
            prev = prev.next;
        }

        if (left != null) {
            prev.next = left;
        }

        if (right != null) {
            prev.next = right;
        }

        return fakeHead.next;
    }

    class ListNode {

        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }

}
