package com.smpaaark.leetcode.binarysearch;

public class Q162 {

    public static void main(String[] args) {
        Q162 q = new Q162();
        System.out.println(q.findPeakElement(new int[]{7,2,3,4,3,2,1}));
    }

    public int findPeakElement(int[] nums) {
        int N = nums.length;
        if (N == 1) {
            return 0;
        }

        int left = 0, right = N - 1;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return (left == N - 1 || nums[left] > nums[left + 1]) ? left : right;
    }

}
