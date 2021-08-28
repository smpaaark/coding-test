package com.smpaaark.leetcode.recursion;

public class Q2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode();
        fakeHead.next = addTwoNumbers(l1, l2, 0);

        return fakeHead.next;
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        int num1 = (l1 != null) ? l1.val : 0;
        int num2 = (l2 != null) ? l2.val : 0;
        int sum = num1 + num2 + carry;
        carry = sum / 10;
        sum %= 10;

        ListNode newNode = new ListNode(sum);

        ListNode nextL1 = (l1 != null) ? l1.next : null;
        ListNode nextL2 = (l2 != null) ? l2.next : null;

        newNode.next = addTwoNumbers(nextL1, nextL2, carry);

        return newNode;
    }

    class ListNode {

        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }

}
