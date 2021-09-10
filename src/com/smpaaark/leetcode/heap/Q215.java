package com.smpaaark.leetcode.heap;

public class Q215 {

    public int findKthLargest(int[] nums, int k) {
        return solution(nums, 0, nums.length - 1, k);
    }

    private int solution(int[] nums, int low, int high, int k) {
        int pivot = low;

        for (int i = low; i < high; i++) {
            if (nums[i] <= nums[high]) {
                swap(nums, pivot, i);
                pivot++;
            }
        }

        swap(nums, pivot, high);

        int currentK = high - pivot + 1;
        if (currentK == k) {
            return nums[pivot];
        }

        if (currentK > k) {
            return solution(nums, pivot + 1, high, k);
        }

        return solution(nums, low, pivot - 1, k - currentK);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
