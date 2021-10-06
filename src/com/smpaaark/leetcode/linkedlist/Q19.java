package com.smpaaark.leetcode.linkedlist;

public class Q19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fakeHead = new ListNode();
        fakeHead.next = head;
        ListNode slow = fakeHead;
        ListNode fast = fakeHead;
        ListNode prev = fakeHead;

        while (n > 0) {
            fast = fast.next;
            n--;
        }

        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        prev.next = slow.next;

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
