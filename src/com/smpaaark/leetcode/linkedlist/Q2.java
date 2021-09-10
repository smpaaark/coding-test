package com.smpaaark.leetcode.linkedlist;

public class Q2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode();
        ListNode prevNode = fakeHead;

        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;

            int sum = num1 + num2 + carry;
            carry = sum / 10;
            sum %= 10;

            ListNode node = new ListNode(sum);
            prevNode.next = node;
            prevNode = prevNode.next;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
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
