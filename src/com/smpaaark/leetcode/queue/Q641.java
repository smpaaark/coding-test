package com.smpaaark.leetcode.queue;

public class Q641 {

    class MyCircularDeque {

        int maxSize;
        int currentSize;
        ListNode head;
        ListNode tail;

        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            maxSize = k;
            head = new ListNode(-1);
            tail = new ListNode(-1);
            head.next = tail;
            tail.prev = head;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }

            ListNode newNode = new ListNode(value);

            head.next.prev = newNode;
            newNode.next = head.next;
            head.next = newNode;
            newNode.prev = head;
            currentSize++;

            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }

            ListNode newNode = new ListNode(value);

            tail.prev.next = newNode;
            newNode.prev = tail.prev;
            tail.prev = newNode;
            newNode.next = tail;

            currentSize++;

            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }

            ListNode deleteNode = head.next;
            head.next = deleteNode.next;
            deleteNode.next.prev = head;
            deleteNode = null;

            currentSize--;

            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }

            ListNode deleteNode = tail.prev;
            tail.prev = deleteNode.prev;
            deleteNode.prev.next = tail;
            deleteNode = null;

            currentSize--;

            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if (isEmpty()) {
                return -1;
            }

            return head.next.value;
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if (isEmpty()) {
                return -1;
            }

            return tail.prev.value;
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return currentSize == 0 ? true : false;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return currentSize == maxSize ? true : false;
        }

    }

    class ListNode {

        int value;
        ListNode prev;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }

    }

}
