package com.smpaaark.leetcode.binarysearch;

public class Q33 {

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                if ()

            } else {

            }
        }
    }

}
