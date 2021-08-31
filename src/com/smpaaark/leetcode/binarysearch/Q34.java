package com.smpaaark.leetcode.binarysearch;

import java.util.Arrays;

public class Q34 {

    public static void main(String[] args) {
        Q34 q = new Q34();
        int[] result = q.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        Arrays.stream(result).forEach(System.out::println);
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);

        return result;
    }

    private int findFirst(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int findIndex = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

            if (nums[mid] == target) {
                findIndex = mid;
            }
        }

        return findIndex;
    }

    private int findLast(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int findIndex = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

            if (nums[mid] == target) {
                findIndex = mid;
            }
        }

        return findIndex;
    }

}
