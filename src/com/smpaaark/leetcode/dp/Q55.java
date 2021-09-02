package com.smpaaark.leetcode.dp;

public class Q55 {

    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxIndex) {
                return false;
            }

            int jumpIndex = i + nums[i];
            maxIndex = Math.max(maxIndex, jumpIndex);
            if (maxIndex >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }

}
