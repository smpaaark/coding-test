package com.smpaaark.leetcode.heap;

public class Q215 {

    public int findKthLargest(int[] nums, int k) {
        return solution(nums, 0, nums.length - 1, k);
    }

    private int solution(int[] nums, int low, int high, int k) {
        int pivot = low;

        for (int i = 0; i < high - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                
            }
        }
    }

}
