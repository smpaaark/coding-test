package com.smpaaark.leetcode.linkedlist;

public class Q19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }

        ListNode fakeHead = new ListNode();
        fakeHead.next = head;
        ListNode slow = fakeHead;
        ListNode fast = fakeHead;
        while (n-- > 0) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

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
