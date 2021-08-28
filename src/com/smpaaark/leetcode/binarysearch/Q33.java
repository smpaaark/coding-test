package com.smpaaark.leetcode.binarysearch;

public class Q33 {

    public static void main(String[] args) {
        Q33 q = new Q33();
        System.out.println(q.search(new int[] {4,5,6,7,8,1,2,3}, 8));
    }

    public int search(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;
        while (startIndex <= endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            if (nums[midIndex] == target) {
                return midIndex;
            }

            if (nums[startIndex] <= nums[midIndex]) {
                if (target >= nums[startIndex] && target <= nums[midIndex]) {
                    endIndex = midIndex - 1;
                } else {
                    startIndex = midIndex + 1;
                }
            }

            if (nums[midIndex] < nums[endIndex]) {
                if (target >= nums[midIndex] && target <= nums[endIndex]) {
                    startIndex = midIndex + 1;
                } else {
                    endIndex = midIndex - 1;
                }
            }
        }

        return -1;
    }

}
