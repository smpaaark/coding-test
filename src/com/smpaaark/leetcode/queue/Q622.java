package com.smpaaark.leetcode.queue;

public class Q622 {

    class MyCircularQueue {

        int[] array;
        int front = 0;
        int rear = -1;
        int count = 0;

        public MyCircularQueue(int k) {
            array = new int[k];
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }

            rear = (rear + 1) % array.length;
            array[rear] = value;
            count++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }

            front = (front + 1) % array.length;
            count--;
            return true;
        }

        public int Front() {
            if (isEmpty()) {
                return -1;
            }

            return array[front];
        }

        public int Rear() {
            if (isEmpty()) {
                return -1;
            }

            return array[rear];
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public boolean isFull() {
            return count == array.length;
        }

    }

}
