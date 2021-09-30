package com.smpaaark.leetcode.heap;

public class Q215 {

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int low, int high, int k) {
        int pivot = low;

        for (int i = low; i < high; i++) {
            pivot = validateAndSwap(nums, high, pivot, i);
        }

        swap(nums, pivot, high);

        int currentK = high - pivot + 1;

        if (currentK == k) {
            return nums[pivot];
        }

        if (currentK > k) {
            return quickSelect(nums, pivot + 1, high, k);
        }

        return quickSelect(nums, low, pivot - 1, k - currentK);
    }

    private int validateAndSwap(int[] nums, int high, int pivot, int i) {
        if (nums[i] <= nums[high]) {
            swap(nums, pivot++, i);
        }
        return pivot;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
