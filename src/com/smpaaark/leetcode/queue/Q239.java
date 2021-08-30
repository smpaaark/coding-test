package com.smpaaark.leetcode.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q239 {

    public static void main(String[] args) {
        Q239 q = new Q239();
        System.out.println(q.maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }

        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peek() <= i - k) {
                queue.poll();
            }

            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }

            queue.offerLast(i);
            if (i >= k - 1) {
                result[resultIndex++] = nums[queue.peek()];
            }
        }

        return result;
    }

}
