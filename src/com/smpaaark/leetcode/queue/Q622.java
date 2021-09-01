package com.smpaaark.leetcode.queue;

public class Q622 {

    class MyCircularQueue {

        int[] queue;
        int maxSize;
        int currentSize;
        int front;
        int rear = -1;

        public MyCircularQueue(int k) {
            queue = new int[k];
            maxSize = k;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }

            rear++;
            if (rear == maxSize) {
                rear %= maxSize;
            }

            queue[rear] = value;
            currentSize++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }

            front++;
            if (front == maxSize) {
                front %= maxSize;
            }

            currentSize--;
            return true;
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }

            return queue[front];
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }

            return queue[rear];
        }

        public boolean isEmpty() {
            return currentSize == 0 ? true : false;
        }

        public boolean isFull() {
            return currentSize == maxSize ? true : false;
        }

    }

}
