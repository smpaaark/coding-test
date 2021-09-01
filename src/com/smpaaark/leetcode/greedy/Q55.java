package com.smpaaark.leetcode.greedy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Q55 {

    public boolean canJump(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            if (index + nums[index] >= nums.length - 1) {
                return true;
            }

            for (int i = index + nums[index]; i >= index + 1; i--) {
                if (!set.contains(i)) {
                    queue.offer(i);
                    set.add(i);
                }
            }
        }

        return false;
    }

    public boolean canJump2(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }

            max = Math.max(max, i + nums[i]);
        }

        return true;
    }

}
