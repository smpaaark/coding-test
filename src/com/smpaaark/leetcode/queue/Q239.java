package com.smpaaark.leetcode.queue;

import java.util.*;

public class Q239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);
            if (i >= k - 1) {
                result[resultIndex++] = nums[deque.peek()];
            }
        }

        return result;
    }

}
