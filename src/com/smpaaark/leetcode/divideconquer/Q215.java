package com.smpaaark.leetcode.divideconquer;

public class Q215 {

    public static void main(String[] args) {
        Q215 q = new Q215();
        System.out.println(q.findKthLargest(new int[] {3, 7, 4, 5, 5}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int low, int high, int k) {
        int pivot = low;

        for (int i = low; i < high; i++) {
            if (nums[i] <= nums[high]) {
                swap(nums, pivot, i);
                pivot++;
            }
        }

        swap(nums, pivot, high);

        int count = high - pivot + 1;
        if (count == k) {
            return nums[pivot];
        }

        if (count > k) {
            return quickSelect(nums, pivot + 1, high, k);
        }

        return quickSelect(nums, low, pivot - 1, k - count);
    }

    private void swap(int[] nums, int pivot, int i) {
        int temp = nums[pivot];
        nums[pivot] = nums[i];
        nums[i] = temp;
    }

}
