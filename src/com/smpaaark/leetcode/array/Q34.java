package com.smpaaark.leetcode.array;

public class Q34 {

    public static void main(String[] args) {
        Q34 q = new Q34();
        System.out.println(q.searchRange2(new int[] {5,7,7,8,8,10}, 8));
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }

        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                break;
            }

            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (start > end) {
            return new int[] {-1, -1};
        }

        int left = mid;
        while (left > 0 && nums[left - 1] == target) {
            left--;
        }

        int right = mid;
        while (right < nums.length - 1 && nums[right + 1] == target) {
            right++;
        }

        return new int[] {left, right};
    }

    public int[] searchRange2(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }

        int left = findLeft(nums, target);
        int right = findRight(nums, target);

        return new int[] {left, right};
    }

    private int findLeft(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

            if (nums[mid] == target) {
                result = mid;
            }
        }

        return result;
    }

    private int findRight(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

            if (nums[mid] == target) {
                result = mid;
            }
        }

        return result;
    }

}
