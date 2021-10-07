package com.smpaaark.leetcode.sorting;

import java.util.Arrays;

public class Q75 {

    public static void main(String[] args) {
        Q75 q = new Q75();
        int[] nums = {2, 0, 2, 1, 1, 0};
        q.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
//        if (nums.length < 2) {
//            return;
//        }
//
//        quickSort(nums, 0, nums.length - 1);
        // 1-pass
        int p1 = 0;
        int p2 = nums.length - 1;
        int index = 0;
        while (index <= p2) {
            if (nums[index] == 0) {
                swap(nums, p1, index);
                p1++;
            }
            if (nums[index] == 2) {
                swap(nums, p2, index);
                p2--;
                index--;
            }
            index++;
        }
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low > high) {
            return;
        }

        int pivot = low;
        for (int i = low; i < high; i++) {
            if (nums[i] <= nums[high]) {
                swap(nums, pivot, i);
                pivot++;
            }
        }

        swap(nums, pivot, high);
        quickSort(nums, low, pivot - 1);
        quickSort(nums, pivot + 1, high);
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
