package com.smpaaark.leetcode.bit;

public class Q287 {

    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] ^ nums[j]) == 0) {
                    return nums[i];
                }
            }
        }

        return -1;
    }

}
